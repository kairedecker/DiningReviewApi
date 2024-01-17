package com.example.DiningReviewApi.repository;

import com.example.DiningReviewApi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
