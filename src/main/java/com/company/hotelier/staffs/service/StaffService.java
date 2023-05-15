package com.company.hotelier.staffs.service;


import com.company.hotelier.staffs.dto.StaffDto;
import com.company.hotelier.staffs.entity.Staff;
import com.company.hotelier.error.StaffNotFoundException;
import com.company.hotelier.staffs.mapper.StaffMapper;
import com.company.hotelier.staffs.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    public List<StaffDto> getAll() {
        List<Staff> staffList = staffRepository.findAll();
        return staffMapper.toStaffDtoList(staffList);
    }

    public StaffDto findById(Integer id){
        return staffRepository.findById(id).stream()
                .findFirst()
                .map(staffMapper ::toStaffDto)
                .orElseThrow(()-> new StaffNotFoundException("Staff not found with given id: " + id));
    }

    public void add(StaffDto staffDto){
        Staff staff = staffMapper.toStaff(staffDto);
        staffRepository.save(staff);
    }

    public void delete(Integer id){
        Staff staff = staffMapper.toStaff(findById(id));
        staffRepository.delete(staff);
    }

    public void update(Integer id, StaffDto staffDto){
        Staff staff = staffMapper.toStaff(findById(id));

        String name = staffDto.getName();
        if(Objects.nonNull(name)){
            staff.setName(name);
        }

        String instagram = staffDto.getInstagram();
        if(Objects.nonNull(instagram)){
            staff.setName(instagram);
        }

        String twitter = staffDto.getTwitter();
        if(Objects.nonNull(twitter)){
            staff.setName(twitter);
        }

        String fbAccount = staffDto.getFbAccount();
        if(Objects.nonNull(fbAccount)){
            staff.setName(fbAccount);
        }

        staffRepository.save(staff);
    }
}
