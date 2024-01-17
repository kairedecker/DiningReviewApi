package com.example.DiningReviewApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long id;

    private String name;
    private Long zipCode;
    private Float  peanutScoreAverage;
    private Float eggScoreAverage;
    private Float dairyScoreAverage;
    private Float overallScore;

    public Restaurant(Restaurant restaurant){
        this.name = restaurant.getName();
        this.peanutScoreAverage = restaurant.getPeanutScoreAverage();
        this.eggScoreAverage = restaurant.getEggScoreAverage();
        this.dairyScoreAverage = restaurant.getDairyScoreAverage();
        this.overallScore = restaurant.getOverallScore();
    }
}
