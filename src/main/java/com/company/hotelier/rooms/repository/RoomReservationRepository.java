package com.company.hotelier.rooms.repository;

import com.company.hotelier.rooms.entity.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {
}
