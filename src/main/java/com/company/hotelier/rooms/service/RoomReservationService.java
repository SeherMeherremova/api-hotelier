package com.company.hotelier.rooms.service;

import com.company.hotelier.rooms.dto.request.RoomReservationRequestDto;
import com.company.hotelier.rooms.mapper.RoomReservationMapper;
import com.company.hotelier.rooms.repository.RoomReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomReservationService {

    private final RoomReservationRepository roomReservationRepository;
    private final RoomReservationMapper roomReservationMapper;

    public void check(RoomReservationRequestDto requestDto){

    }

}
