package com.example.DiningReviewApi.repository;

import com.example.DiningReviewApi.model.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAllByZipCodeOrderByZipCodeDesc(Long zipCode);

    List<Restaurant> findAllByZipCodeAndPeanutScoreIsNotNullOrderByZipCodeDesc(Long zipCode);
    List<Restaurant> findAllByZipCodeAndEggScoreIsNotNullOrderByZipCodeDesc(Long zipCode);
    List<Restaurant> findAllByZipCodeAndDairyScoreIsNotNullOrderByZipCodeDesc(Long zipCode);

}
