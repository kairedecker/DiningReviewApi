package com.example.DiningReviewApi.controller;

import com.example.DiningReviewApi.model.User;
import com.example.DiningReviewApi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ResponseEntity getAllUsers(){
        Iterable<User> users = this.userRepository.findAll();
        return new ResponseEntity(users, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable String id){
        Optional<User> userOptional = this.userRepository.findById(id);
        if(userOptional.isEmpty()){
            return new ResponseEntity<>("User not found!" ,HttpStatus.BAD_REQUEST);
        }
        User user = userOptional.get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create/")
    public ResponseEntity createUser(@RequestBody User newUser){
        if(this.userRepository.existsById(newUser.getUsername())){
            return new ResponseEntity<>("User already exists!", HttpStatus.BAD_REQUEST);
        }

        // TODO: Check if user attributes are defined and correct!
        User createdUser = this.userRepository.save(newUser);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable String id, @RequestBody User updateUser){
        Optional<User> userToUpdateOptional = this.userRepository.findById(id);

        if(userToUpdateOptional.isEmpty()){
            return new ResponseEntity<>("User not found!", HttpStatus.BAD_REQUEST);
        }
        User userToUpdate = userToUpdateOptional.get();

        // TODO: Check if user attributes are defined and correct!
        userToUpdate.setCity(updateUser.getCity());
        userToUpdate.setState(userToUpdate.getState());
        userToUpdate.setZipCode(userToUpdate.getZipCode());
        userToUpdate.setInterestedInDairyAllergies(updateUser.getInterestedInDairyAllergies());
        userToUpdate.setInterestedInPeanutAllergies(updateUser.getInterestedInPeanutAllergies());
        userToUpdate.setInterestedInEggAllergies(updateUser.getInterestedInEggAllergies());

        User updatedUser = this.userRepository.save(userToUpdate);

        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateToAdmin/{id}")
    public ResponseEntity updateUserToAdmin(@PathVariable String id){
        Optional<User> userToUpdateOptional = this.userRepository.findById(id);

        if(userToUpdateOptional.isEmpty()){
            return new ResponseEntity<>("User not found!", HttpStatus.BAD_REQUEST);
        }
        User userToUpdate = userToUpdateOptional.get();
        userToUpdate.setIsAdmin(Boolean.TRUE);

        User updatedUser = this.userRepository.save(userToUpdate);

        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }
}
