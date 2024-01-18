package com.example.DiningReviewApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
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

}
