package com.company.hotelier.rooms.service;

import com.company.hotelier.error.RoomNotFoundException;
import com.company.hotelier.rooms.dto.RoomDto;
import com.company.hotelier.rooms.dto.request.RoomFilter;
import com.company.hotelier.rooms.entity.Room;
import com.company.hotelier.rooms.mapper.RoomMapper;
import com.company.hotelier.rooms.model.RoomState;
import com.company.hotelier.rooms.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public List<RoomDto> getAll(Integer page, Integer size, String field, RoomFilter roomFilter) {
        // TODO: fix pagination mechanism
        List<Room> rooms = roomRepository.findAll(
                        PageRequest.of(page, size).withSort(Sort.by((field)))).stream()
                .filter(room -> RoomState.AVAILABLE.getState() == room.getState())
                .collect(Collectors.toList());

        if (Objects.nonNull(roomFilter.getChildCount())) {
            filterByChildCount(rooms, roomFilter);
        }

        if (Objects.nonNull(roomFilter.getAdultCount())) {
            filterByAdultCount(rooms, roomFilter);
        }

        // TODO: fix check in/out filter
//        if (Objects.nonNull(roomFilter.getCheckIn()) && Objects.nonNull(roomFilter.getCheckOut())) {
//            RoomReservation roomReservation = new RoomReservation();
//        }

        return roomMapper.toRoomDtoList(rooms);
    }

    public RoomDto findById(Long id) {
        return roomRepository.findById(id).stream()
                .findFirst()
                .map(roomMapper::toRoomDto)
                .orElseThrow(() -> new RoomNotFoundException("Room not found with given id: " + id));
    }

    public void add(RoomDto roomDto) {
        Room room = roomMapper.toRoom(roomDto);
        roomRepository.save(room);
    }

    public void delete(Long id) {
        Room room = roomMapper.toRoom(findById(id));
        roomRepository.delete(room);
    }

    public void update(Long id, RoomDto roomDto) {
        Room room = roomRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new RoomNotFoundException("Room not found with given id: " + id));

        roomMapper.toRoom(room, roomDto);
        roomRepository.save(room);
    }

    private List<Room> filterByAdultCount(List<Room> rooms, RoomFilter roomFilter) {
        return rooms.stream()
                .filter(room -> room.getAdultCount() >= roomFilter.getAdultCount())
                .collect(Collectors.toList());
    }

    private List<Room> filterByChildCount(List<Room> rooms, RoomFilter roomFilter) {
        return rooms.stream()
                .filter(room -> room.getChildCount() >= roomFilter.getChildCount())
                .collect(Collectors.toList());
    }

}
