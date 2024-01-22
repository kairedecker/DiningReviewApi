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
@Table(name="CUSTOM_USER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "username")
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

    @OneToMany(mappedBy = "username",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonManagedReference(value = "user-review")
    private List<DiningReview> reviews;

}
