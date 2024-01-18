package com.example.DiningReviewApi.controller;

import com.example.DiningReviewApi.enums.DiningReviewEnum;
import com.example.DiningReviewApi.model.DiningReview;
import com.example.DiningReviewApi.model.Restaurant;
import com.example.DiningReviewApi.repository.DiningReviewRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class DiningReviewController {

    DiningReviewRepository diningReviewRepository;

    public DiningReviewController(DiningReviewRepository diningReviewRepository){
        this.diningReviewRepository = diningReviewRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity getReview(@RequestParam Long id){
        Optional<DiningReview> diningReviewOptional = this.diningReviewRepository.findById(id);
        if(diningReviewOptional.isEmpty()){
            return new ResponseEntity<>("Review not found!", HttpStatus.BAD_REQUEST);
        }
        DiningReview diningReview = diningReviewOptional.get();
        return new ResponseEntity<>(diningReview, HttpStatus.OK);
    }

    @GetMapping("/{status}")
    public ResponseEntity getReviewsByStatus(@RequestParam String status){
        DiningReviewEnum statusReceived = statusHelper(status);
        if(statusReceived == null){
            return new ResponseEntity<>("Incorrect status submitted!", HttpStatus.BAD_REQUEST);
        }

        List<DiningReview> diningReviewsByStatus = this.diningReviewRepository.findAllByStatus(statusReceived);
        return new ResponseEntity<>(diningReviewsByStatus, HttpStatus.OK);
    }

    private DiningReviewEnum statusHelper(String statusToGet){
        for(DiningReviewEnum statusInEnum : DiningReviewEnum.values()){
            if(statusInEnum.name().equalsIgnoreCase(statusToGet)){
                return statusInEnum;
            }
        }
        return null;
    }

    @PostMapping("/submit")
    public ResponseEntity createNewReview(@RequestBody DiningReview newDiningReview){
        // TODO: Check if newDiningReview attributes are defined and correct!
        newDiningReview.setStatus(DiningReviewEnum.PENDING);

        DiningReview createdDiningReview = this.diningReviewRepository.save(newDiningReview);

        return new ResponseEntity<>(createdDiningReview, HttpStatus.CREATED);
    }

    @PostMapping("/admin/{id}")
    public ResponseEntity updateReviewStatus(@PathVariable Long id, @RequestBody String status){
        // TODO: Check if status arrives
        System.out.println(status);

        DiningReviewEnum statusReceived = statusHelper(status);
        if(statusReceived == null){
            return new ResponseEntity<>("Incorrect status submitted!", HttpStatus.BAD_REQUEST);
        }

        Optional<DiningReview> diningReviewToUpdateOptional = this.diningReviewRepository.findById(id);
        if(diningReviewToUpdateOptional.isEmpty()){
            return new ResponseEntity<>("Review not found!", HttpStatus.BAD_REQUEST);
        }
        DiningReview diningReviewToUpdate = diningReviewToUpdateOptional.get();

        if(diningReviewToUpdate.getStatus() != DiningReviewEnum.PENDING){
            return new ResponseEntity<>("Review already updated! Current Status: " + diningReviewToUpdate.getStatus().toString(), HttpStatus.BAD_REQUEST);
        }

        diningReviewToUpdate.setStatus(statusReceived);

        // TODO: Calculation of scores if a new Review is added and approved by Admin!

        DiningReview diningReviewUpdated = this.diningReviewRepository.save(diningReviewToUpdate);

        return new ResponseEntity<>(diningReviewUpdated, HttpStatus.OK);
    }






}
