package com.company.hotelier.rooms.repository;

import com.company.hotelier.rooms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
