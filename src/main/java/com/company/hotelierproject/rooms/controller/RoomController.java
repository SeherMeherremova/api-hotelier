package com.company.hotelierproject.rooms.controller;

import com.company.hotelierproject.rooms.dto.RoomDto;
import com.company.hotelierproject.rooms.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public List<RoomDto> getAll() {
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody RoomDto roomDto) {
        roomService.add(roomDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody RoomDto roomDto) {
        roomService.update(id, roomDto);
    }

}
