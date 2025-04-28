package com.lukaszosial.smartparking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lukaszosial.smartparking.model.ParkingSpot;
import com.lukaszosial.smartparking.model.Reservation;
import com.lukaszosial.smartparking.repository.ParkingSpotRepository;
import com.lukaszosial.smartparking.service.ReservationService;

@RestController
public class ReservationController {
	@Autowired
	ReservationService reservationService;

	@Autowired
	ParkingSpotRepository parkingSpotRepository;

	@GetMapping("/reservations")
	public List<Reservation> getReservations() {
		return reservationService.getReservations();
	}

	@GetMapping("/reservations/{reservationId}")
	public Optional<Reservation> getReservationById(@PathVariable int reservationId) {
		return reservationService.getReservationById(reservationId);
	}

	@PostMapping("/reservations")
	public void addReservation(@RequestBody Reservation reservation) {
		ParkingSpot parkingSpot = parkingSpotRepository.findById(reservation.getParkingSpot().getId())
				.orElseThrow(() -> new RuntimeException("Parking spot not found"));
		reservationService.addReservation(reservation, parkingSpot);
	}

	@PutMapping("/reservations")
	public void updateReservation(@RequestBody Reservation reservation) {
		reservationService.updateReservation(reservation);
	}

	@DeleteMapping("/reservations/{reservationId}")
	public void deleteReservation(@PathVariable int reservationId) {
		reservationService.deleteReservation(reservationId);
	}
}
