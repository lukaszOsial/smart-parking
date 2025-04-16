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
import com.lukaszosial.smartparking.service.ParkingSpotService;

@RestController
public class ParkingSpotController {
	
	@Autowired
	ParkingSpotService parkingSpotService;
	
	@GetMapping("/parking_spots")
	public List<ParkingSpot> getParkingSpots() {
		return parkingSpotService.getParkingSpots();
	}
	
	@GetMapping("/parking_spots/{parkingSpotId}")
	public Optional<ParkingSpot> getParkingSpotById(@PathVariable int parkingSpotId) {
		return parkingSpotService.getParkingSpotById(parkingSpotId);
	}
	
	@PostMapping("/parking_spots")
	public void addParkingSpot(@RequestBody ParkingSpot parkingSpot) {
		parkingSpotService.addParkingSpot(parkingSpot);
	}
	
	@PutMapping("/parking_spots")
	public void updateParkingSpot(@RequestBody ParkingSpot parkingSpot) {
		parkingSpotService.updateParkingSpot(parkingSpot);
	}
	
	@DeleteMapping("/parking_spots/{parkingSpotId}")
	public void deleteParkingSpot(@PathVariable int parkingSpotId) {
		parkingSpotService.deleteParkingSpot(parkingSpotId);
	}
}
