package com.company.hotelierproject.rooms.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "rooms")
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private Boolean wifi;
    private Double rate;

    @Column(name = "bed_count")
    private Integer bedCount;

    @Column(name = "bath_count")
    private Integer bathCount;

    @Column(name = "room_count")
    private Integer roomCount;

}
