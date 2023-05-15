package com.company.hotelier.staffs.repository;


import com.company.hotelier.staffs.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
