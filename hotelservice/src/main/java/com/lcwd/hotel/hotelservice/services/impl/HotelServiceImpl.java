package com.lcwd.hotel.hotelservice.services.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.hotelservice.entities.Hotel;
import com.lcwd.hotel.hotelservice.exception.ResourceNotFoundException;
import com.lcwd.hotel.hotelservice.repositories.HotelRepository;
import com.lcwd.hotel.hotelservice.services.HotelService;


@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        //UUID.randomUUID().toString();
        String hotelId= UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
      return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
    
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel not found"));
    }
    
}
