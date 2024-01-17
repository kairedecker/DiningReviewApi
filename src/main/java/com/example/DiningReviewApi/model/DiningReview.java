package com.example.DiningReviewApi.model;

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
    @NonNull
    private Long id;

    private String username;
    private Long restaurantId;
    private Long peanutScore;
    private Long eggScore;
    private Long dairyScore;
    private String commentary;
    private String status;

    public DiningReview(DiningReview diningReview){
        this.username = diningReview.getUsername();
        this.restaurantId = diningReview.getRestaurantId();
        this.peanutScore = diningReview.getPeanutScore();
        this.eggScore = diningReview.getEggScore();
        this.dairyScore = diningReview.getDairyScore();
        this.commentary = diningReview.getCommentary();
        this.status = diningReview.getStatus();
    }

}
