package com.lcwd.user.service.userservice.services.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.userservice.entities.Hotel;
import com.lcwd.user.service.userservice.entities.Rating;
import com.lcwd.user.service.userservice.entities.User;
import com.lcwd.user.service.userservice.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.userservice.external.services.HotelService;
import com.lcwd.user.service.userservice.repositories.UserRepository;
import com.lcwd.user.service.userservice.services.UserService;



@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestClient restClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;
    
    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String uid=UUID.randomUUID().toString();
        user.setUserId(uid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        User u= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("given user id not found"));

        //URI uri=null;
        //fetch rating details from RATING services
        String url="http://RATINGSERVICE/ratings/users/"+userId;
        Rating[] forObject=restTemplate.getForObject(url,Rating[].class);

        List<Rating> ratings=Arrays.stream(forObject).toList();
        
        //fetching rating using restclient which is modern solution and preffered
        // ArrayList<Rating> forObject=restClient.get().uri("/users/{userId}", userId)
        // .retrieve()
        // .body(ArrayList.class);
        //restTemplate.getForObjec

        //logger.info("{} ", forObject);
        List<Rating> ratingList = ratings.stream().map(rating->{
          //  ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
          //  Hotel hotel=forEntity.getBody();
          Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);

            return rating;

        }).collect(Collectors.toList());


        u.setRatings(ratingList);

        return u;
    
    }

    @Override
    public void deleteUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public User updatUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatUser'");
    }
    
}
