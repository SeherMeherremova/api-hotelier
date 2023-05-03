package com.company.hotelierproject.rooms.service;

import com.company.hotelierproject.rooms.dto.RoomDto;
import com.company.hotelierproject.rooms.entity.Room;
import com.company.hotelierproject.rooms.error.RoomNotFoundException;
import com.company.hotelierproject.rooms.mapper.RoomMapper;
import com.company.hotelierproject.rooms.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public List<RoomDto> getAll(){
        List<Room> roomsList = roomRepository.findAll();
        return roomMapper.toRoomDtoList(roomsList);
    }

    public RoomDto findById(Long id){
        return roomRepository.findById(id).stream()
                .findFirst()
                .map(roomMapper::toRoomDto)
                .orElseThrow(() -> new RoomNotFoundException("Room not found with given id: " + id));
    }

    public void  add(RoomDto roomDto){
        Room room = roomMapper.toRoom(roomDto);
        roomRepository.save(room);
    }

    public void delete(Long id){
        Room room = roomMapper.toRoom(findById(id));
        roomRepository.delete(room);
    }

    public void update (Long id, RoomDto roomDto){
        Room room = roomMapper.toRoom(findById(id));

        Integer roomCount = roomDto.getRoomCount();
        if (Objects.nonNull(roomCount)) {
            room.setRoomCount(roomCount);
        }

        Double rate = roomDto.getRate();
        if (Objects.nonNull(rate)) {
            room.setRate(rate);
        }

        Integer bathCount = roomDto.getBathCount();
        if (Objects.nonNull(bathCount)) {
            room.setBathCount(bathCount);
        }

        Integer bedCount = roomDto.getBedCount();
        if (Objects.nonNull(bedCount)) {
            room.setBedCount(bedCount);
        }

       Boolean wifi = roomDto.getWifi();
        if (Objects.nonNull(wifi)) {
            room.setWifi(wifi);
        }

        Integer price = roomDto.getPrice();
        if (Objects.nonNull(price)) {
            room.setPrice(price);
        }

        String name = roomDto.getName();
        if (Objects.nonNull(name)) {
            room.setName(name);
        }
        roomRepository.save(room);
    }
}
