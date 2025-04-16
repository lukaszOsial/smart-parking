package com.lukaszosial.smartparking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukaszosial.smartparking.model.ParkingSpot;
import com.lukaszosial.smartparking.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {
	
	@Autowired
	ParkingSpotRepository parkingSpotRepository;

	public List<ParkingSpot> getParkingSpots() {
		return parkingSpotRepository.findAll();
	}

	public Optional<ParkingSpot> getParkingSpotById(Integer parkingSpotId) {
		return parkingSpotRepository.findById(parkingSpotId);
	}

	public void addParkingSpot(ParkingSpot parkingSpot) {
		parkingSpotRepository.save(parkingSpot);
	}

	public void updateParkingSpot(ParkingSpot parkingSpot) {
		if (parkingSpotRepository.existsById(parkingSpot.getId())) {
			parkingSpotRepository.save(parkingSpot);
		} else {
			throw new RuntimeException("Parking spot with id: " + parkingSpot.getId() + " not found");
		}
	}

	public void deleteParkingSpot(Integer parkingSpotId) {
		parkingSpotRepository.deleteById(parkingSpotId);
	}
}
