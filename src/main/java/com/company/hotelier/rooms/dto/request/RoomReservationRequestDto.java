package com.company.hotelier.rooms.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RoomReservationRequestDto {

    private Long roomId;
    private LocalDate beginDate;
    private LocalDate endDate;
}
