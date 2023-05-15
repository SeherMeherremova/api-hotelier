package com.company.hotelier.rooms.entity;

import com.company.hotelier.rooms.model.RoomState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer state;

    @Column(name = "adult_count")
    private Integer adultCount;

    @Column(name = "child_count")
    private Integer childCount;

    @Column(name = "bed_count")
    private Integer bedCount;

    @Column(name = "bath_count")
    private Integer bathCount;

    @Column(name = "room_count")
    private Integer roomCount;

}
