package com.lcwd.user.service.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.userservice.entities.Rating;
import com.lcwd.user.service.userservice.external.services.RatingService;


@SpringBootTest
class UserserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	@Test
	void createRating(){
		Rating rating= Rating.builder().rating(10).userId("").hotelId("").feedback("this is created using feign client").build();
		Rating savedRating =  ratingService.createRating(rating);
		System.out.println("new rating created");
	}
}
