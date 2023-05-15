package com.company.hotelier.rooms.controller;

import com.company.hotelier.rooms.dto.RoomDto;
import com.company.hotelier.rooms.dto.request.RoomFilter;
import com.company.hotelier.rooms.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
@Validated
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/page/{page}/size/{size}")
    public List<RoomDto> getAll(@PathVariable Integer page,
                                @PathVariable Integer size,
                                @RequestParam(required = false) String field,
                                @Valid RoomFilter roomFilter) {
        return roomService.getAll(page, size, field, roomFilter);
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
