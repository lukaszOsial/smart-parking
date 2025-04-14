package com.lukaszosial.smartparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lukaszosial.smartparking.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
