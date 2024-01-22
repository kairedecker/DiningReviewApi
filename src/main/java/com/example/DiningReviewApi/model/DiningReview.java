package com.example.DiningReviewApi.model;

import com.example.DiningReviewApi.enums.DiningReviewEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private Long restaurantId;
    private Integer peanutScore; // Optional 1-5
    private Integer eggScore; // Optional 1-5
    private Integer dairyScore; // Optional 1-5
    private String commentary;
    private DiningReviewEnum status;

    // Entity relation
    /*
    @OneToOne
    @JoinColumn(name = "restaurantId")
    @JsonBackReference(value = "restaurant-review")
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "username")
    @JsonBackReference(value = "user-review")
    private User user;
    */

}
