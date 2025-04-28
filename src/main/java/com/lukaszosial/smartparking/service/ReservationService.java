package com.lukaszosial.smartparking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukaszosial.smartparking.model.ParkingSpot;
import com.lukaszosial.smartparking.model.Reservation;
import com.lukaszosial.smartparking.repository.ParkingSpotRepository;
import com.lukaszosial.smartparking.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	ParkingSpotRepository parkingSpotRepository;

	public List<Reservation> getReservations() {
		return reservationRepository.findAll();
	}

	public Optional<Reservation> getReservationById(Integer reservationId) {
		return reservationRepository.findById(reservationId);
	}

	public void addReservation(Reservation reservation, ParkingSpot parkingSpot) {
		if (!parkingSpot.getAvailable()) {
			throw new RuntimeException("Parking spot with id: " + parkingSpot.getId() + " is occupied");
		}

		if (!reservation.getEndTime().isAfter(reservation.getStartTime())) {
			throw new RuntimeException("End time reservation must be higher than start time");
		}

		parkingSpot.setAvailable(false);
		reservationRepository.save(reservation);
	}

	public void updateReservation(Reservation reservation) {
		if (reservationRepository.existsById(reservation.getId())) {
			reservationRepository.save(reservation);
		} else {
			throw new RuntimeException("Reservation with id: " + reservation.getId() + " not found");
		}
	}

	public void deleteReservation(Integer reservationId) {
		Optional<Reservation> reservation = reservationRepository.findById(reservationId);
		if (reservation.isPresent()) {
			ParkingSpot parkingSpot = reservation.get().getParkingSpot();
			parkingSpot.setAvailable(true);
			parkingSpotRepository.save(parkingSpot);
			reservationRepository.deleteById(reservationId);
		} else {
			throw new RuntimeException("Reservation not found");
		}
	}

}
