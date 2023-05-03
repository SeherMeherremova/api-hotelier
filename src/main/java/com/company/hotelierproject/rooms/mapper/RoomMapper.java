package com.company.hotelierproject.rooms.mapper;

import com.company.hotelierproject.rooms.dto.RoomDto;
import com.company.hotelierproject.rooms.entity.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RoomMapper {

    public Room toRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setWifi(roomDto.getWifi());
        room.setRoomCount(roomDto.getRoomCount());
        room.setRate(roomDto.getRate());
        room.setName(roomDto.getName());
        room.setPrice(roomDto.getPrice());
        room.setBathCount(roomDto.getBathCount());
        room.setBedCount(roomDto.getBedCount());
        return room;
    }

    public List<RoomDto> toRoomDtoList(List<Room> rooms) {
        var roomDtoList = new ArrayList<RoomDto>();
        for (Room room : rooms) {
            roomDtoList.add(toRoomDto(room));
        }
        return roomDtoList;
    }

    public RoomDto toRoomDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setWifi(room.getWifi());
        roomDto.setRoomCount(room.getRoomCount());
        roomDto.setRate(room.getRate());
        roomDto.setName(room.getName());
        roomDto.setPrice(room.getPrice());
        roomDto.setBathCount(room.getBathCount());
        roomDto.setBedCount(room.getBedCount());
        return roomDto;
    }

}
