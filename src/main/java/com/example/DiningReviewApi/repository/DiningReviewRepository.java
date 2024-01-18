package com.example.DiningReviewApi.repository;

import com.example.DiningReviewApi.enums.DiningReviewEnum;
import com.example.DiningReviewApi.model.DiningReview;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {

    List<DiningReview> findAllByStatus(DiningReviewEnum status);
}
