package com.example.DiningReviewApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="CUSTOM_USER")
public class User {

    @Id
    private String username;

    @Column(name="CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP")
    private Long zipCode;
    @Column(name = "PEANUTALLERGIES")
    private Boolean interestedInPeanutAllergies;
    @Column(name = "EGGALLERGIES")
    private Boolean interestedInEggAllergies;
    @Column(name = "DAIRYALLERGIES")
    private Boolean interestedInDairyAllergies;
    @Column(name="ISADMIN")
    private Boolean isAdmin;

}
