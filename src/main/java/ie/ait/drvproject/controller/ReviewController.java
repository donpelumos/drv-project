package ie.ait.drvproject.controller;

import ie.ait.drvproject.dao.Review;
import ie.ait.drvproject.exception.ReviewNotFoundException;
import ie.ait.drvproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pelumi.Oyefeso on 24-04-2020
 */
@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping(value = {"", "/all"})
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") Integer id){
        Optional<Review> review = reviewService.findReviewById(id);
        if(review.isPresent()){
            ResponseEntity<Review> reviewResponseEntity = new ResponseEntity<>(review.get(), HttpStatus.OK);
            return reviewResponseEntity;
        }
        else{
            throw new ReviewNotFoundException("Requested store review not found");
        }
    }

    @PostMapping("")
    public ResponseEntity<Review> createReview(@Valid @RequestBody Review review){
        Review createdReview = reviewService.saveNewReview(review);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdReview.getReviewId()).toUri();
        return ResponseEntity.created(location).body(createdReview);
    }

    @PutMapping(value = {"", "{id}"})
    public ResponseEntity<Review> updateReview(@Valid @RequestBody Review reviewToUpdate, @PathVariable(value = "id", required = false) Integer id){
        id = (id == null) ? reviewToUpdate.getReviewId() : id;
        Optional<Review> review = reviewService.findReviewById(id);
        if(review.isPresent()){
            reviewToUpdate.setReviewId(id);
            Review updatedReview = reviewService.updateReview(reviewToUpdate);
            ResponseEntity<Review> reviewResponseEntity = new ResponseEntity<>(updatedReview, HttpStatus.OK);
            return reviewResponseEntity;
        }
        else{
            throw new ReviewNotFoundException("Requested review not found");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable("id") Integer id){
        int reviewDeleted = reviewService.deleteReview(id);
        if(reviewDeleted == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        else{
            throw new ReviewNotFoundException("Review with specified id does not exist");
        }
    }
}
