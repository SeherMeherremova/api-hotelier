package com.company.hotelier.staffs.mapper;


import com.company.hotelier.staffs.dto.StaffDto;
import com.company.hotelier.staffs.entity.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StaffMapper {

    Staff toStaff(StaffDto staffDto);

    List<StaffDto> toStaffDtoList(List<Staff> staffs);

    StaffDto toStaffDto(Staff staff);
}
