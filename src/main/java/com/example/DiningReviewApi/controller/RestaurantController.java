package com.example.DiningReviewApi.controller;

import ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;
import com.example.DiningReviewApi.model.Restaurant;
import com.example.DiningReviewApi.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/")
    public ResponseEntity getAllRestaurants(){
        Iterable<Restaurant> restaurants = this.restaurantRepository.findAll();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getRestaurant(@PathVariable Long id){
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if(restaurantOptional.isEmpty()){
            return new ResponseEntity<>("Restaurant not found!", HttpStatus.BAD_REQUEST);
        }
        Restaurant restaurant = restaurantOptional.get();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/zip/{zipCode}/allergy/{allergy}")
    public ResponseEntity getRestaurantsByZip(@PathVariable Long zipCode, @PathVariable String allergy){

        List<Restaurant> restaurants;
        switch (allergy){
            case "peanuts":
                restaurants = this.restaurantRepository.findAllByZipCodeAndPeanutScoreIsNotNullOrderByZipCodeDesc(zipCode);
            case "egg":
                restaurants = this.restaurantRepository.findAllByZipCodeAndEggScoreIsNotNullOrderByZipCodeDesc(zipCode);
            case "dairy":
                restaurants = this.restaurantRepository.findAllByZipCodeAndDairyScoreIsNotNullOrderByZipCodeDesc(zipCode);
            default:
                restaurants = this.restaurantRepository
                        .findAllByZipCodeOrderByZipCodeDesc(zipCode);
        }
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @PostMapping("/create/")
    public ResponseEntity createRestaurant(@RequestBody Restaurant newRestaurant){
        if(this.restaurantRepository.existsById(newRestaurant.getId())){
            return new ResponseEntity<>("Restaurant already exists!", HttpStatus.BAD_REQUEST);
        }
        // TODO: Check if restaurant attributes are defined and correct!
        Restaurant createdRestaurant = this.restaurantRepository.save(newRestaurant);

        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    // TODO: Update given restaurant entity by ID
}
