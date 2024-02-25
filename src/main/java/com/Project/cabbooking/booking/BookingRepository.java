package com.Project.cabbooking.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
//    static List<Booking> FindByCustomeridAscs() {
//        return ;
//    }
//
//    static List<Booking> findByDriverAscs();
}
