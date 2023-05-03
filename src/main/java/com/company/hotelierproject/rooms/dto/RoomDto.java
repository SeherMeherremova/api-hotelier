package com.company.hotelierproject.rooms.dto;

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

}
