package com.company.hotelier.staffs.controller;

import com.company.hotelier.staffs.dto.StaffDto;
import com.company.hotelier.staffs.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping
    public List<StaffDto> getAll() {
        return staffService.getAll();
    }

    @GetMapping("/{id}")
    public StaffDto findById(@PathVariable Integer id) {
        return staffService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody StaffDto staffDto) {
        staffService.add(staffDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        staffService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,
                       @RequestBody StaffDto staffDto) {
        staffService.update(id, staffDto);
    }
}
