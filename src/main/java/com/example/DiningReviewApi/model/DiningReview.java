package com.example.DiningReviewApi.model;

import com.example.DiningReviewApi.enums.DiningReviewEnum;
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

}
