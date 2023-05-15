package com.company.hotelier;

import com.company.hotelier.rooms.repository.RoomRepository;
import com.company.hotelier.rooms.repository.RoomReservationRepository;
import com.company.hotelier.staffs.repository.StaffRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
        RoomRepository.class,
        RoomReservationRepository.class,
        StaffRepository.class
})
public class HotelierProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelierProjectApplication.class, args);
    }

}
