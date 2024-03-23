package com.lcwd.user.service.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.userservice.entities.Hotel;

@Service
@FeignClient(name = "HOTELSERVICE")
public interface HotelService {
    
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
