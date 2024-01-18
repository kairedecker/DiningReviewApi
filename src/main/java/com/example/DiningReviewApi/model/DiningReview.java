package com.example.DiningReviewApi.model;

import com.example.DiningReviewApi.enums.DiningReviewEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private Long restaurantId;
    private Long peanutScore;
    private Long eggScore;
    private Long dairyScore;
    private String commentary;
    private DiningReviewEnum status;

}
