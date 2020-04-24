package ie.ait.drvproject.service;

import ie.ait.drvproject.dao.Review;
import ie.ait.drvproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Pelumi.Oyefeso on 24-04-2020
 */
@Service
public class ReviewService {
    
    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> findReviewById(Integer id){
        return reviewRepository.findById(id);
    }

    public Review saveNewReview(Review item){
        return reviewRepository.save(item);
    }

    public Review updateReview(Review item){
        return reviewRepository.save(item);
    }

    public int deleteReview(Integer id) {
        Optional<Review> item = reviewRepository.findById(id);
        if(item.isPresent()){
            reviewRepository.delete(item.get());
            return 0;
        }
        else{
            return -1;
        }
    }
}
