package com.lcwd.hotel.hotelservice.services;

import com.lcwd.hotel.hotelservice.entities.Hotel;
import java.util.*;
public interface HotelService {

    Hotel create(Hotel hotel);
    
    List<Hotel> getAll();

    Hotel get(String id);

    
}
