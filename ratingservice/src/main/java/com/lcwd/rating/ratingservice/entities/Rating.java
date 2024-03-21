package com.lcwd.rating.ratingservice.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("user_ratings")
public class Rating {


    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
