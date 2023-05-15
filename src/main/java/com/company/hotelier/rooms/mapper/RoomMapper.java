package com.company.hotelier.rooms.mapper;

import com.company.hotelier.rooms.dto.RoomDto;
import com.company.hotelier.rooms.entity.Room;
import com.company.hotelier.rooms.model.RoomState;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {

    Room toRoom(RoomDto roomDto);

    void toRoom(@MappingTarget Room room, RoomDto roomDto);

    List<RoomDto> toRoomDtoList(List<Room> rooms);

    RoomDto toRoomDto(Room room);

    @AfterMapping
    default void mapState(@MappingTarget RoomDto roomDto, Room room) {
        roomDto.setState(RoomState.values(room.getState()));
    }

}
