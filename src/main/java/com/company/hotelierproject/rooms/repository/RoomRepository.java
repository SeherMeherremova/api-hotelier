package com.company.hotelierproject.rooms.repository;

import com.company.hotelierproject.rooms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
