package com.example.DiningReviewApi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Long zipCode;
    private Float peanutScoreAverage;
    private Float eggScoreAverage;
    private Float dairyScoreAverage;
    private Float overallScore;

    @OneToMany(mappedBy = "restaurantId", cascade = CascadeType.ALL)
    //@JsonManagedReference(value = "restaurant-review")
    private List<DiningReview> diningReviews;

}
