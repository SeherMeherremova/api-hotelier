package com.company.hotelier.rooms.mapper;

import com.company.hotelier.rooms.dto.request.RoomReservationRequestDto;
import com.company.hotelier.rooms.entity.RoomReservation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomReservationMapper {

     RoomReservation toRoomReservation(RoomReservationRequestDto roomReservationRequestDto);

     RoomReservationRequestDto toRoomReservationDto(RoomReservation roomReservation);

}
