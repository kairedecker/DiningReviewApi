package com.example.DiningReviewApi.repository;

import com.example.DiningReviewApi.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAllByZipCodeOrderByZipCodeDesc(Long zipCode);

    Boolean existsByNameAndZipCode(String name, Long zipCode);

    List<Restaurant> findAllByZipCodeAndPeanutScoreAverageIsNotNullOrderByZipCodeDesc(Long zipCode);
    List<Restaurant> findAllByZipCodeAndEggScoreAverageIsNotNullOrderByZipCodeDesc(Long zipCode);
    List<Restaurant> findAllByZipCodeAndDairyScoreAverageIsNotNullOrderByZipCodeDesc(Long zipCode);

}
