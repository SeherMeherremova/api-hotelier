package com.company.hotelier.rooms.dto.request;

import lombok.Data;

import javax.validation.constraints.Max;
import java.time.LocalDate;

@Data
public class RoomFilter {

    @Max(value = 10, message = "Child count can not be greater than 10")
    private Integer childCount;

    @Max(value = 10, message = "Adult count can not be greater than 10")
    private Integer adultCount;

    private LocalDate checkIn;

    private LocalDate checkOut;

}
