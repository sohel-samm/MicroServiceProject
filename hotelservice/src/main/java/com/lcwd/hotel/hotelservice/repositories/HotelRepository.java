package com.lcwd.hotel.hotelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotel.hotelservice.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String> {
    
    //create


}
