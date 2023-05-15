package com.company.hotelier.rooms.dto;

import com.company.hotelier.rooms.model.RoomState;
import lombok.Data;

@Data
public class RoomDto {

    private String name;
    private Integer price;
    private Boolean wifi;
    private Integer bedCount;
    private Integer bathCount;
    private Integer roomCount;
    private Double rate;
    private RoomState state;
    private Integer adultCount;
    private Integer childCount;

}
