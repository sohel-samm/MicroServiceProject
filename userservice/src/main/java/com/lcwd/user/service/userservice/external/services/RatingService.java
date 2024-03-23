package com.lcwd.user.service.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.user.service.userservice.entities.Rating;

@Service
@FeignClient(name = "RATINGSERVICE",url = "http://localhost:8083")
public interface RatingService {
    
    //get


    //post
    @PostMapping("/ratings")
    Rating createRating(Rating rating);


    //PUT
    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
    

}
