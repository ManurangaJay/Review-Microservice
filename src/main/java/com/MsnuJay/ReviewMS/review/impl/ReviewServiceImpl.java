package com.MsnuJay.ReviewMS.review.impl;

import com.MsnuJay.ReviewMS.review.Review;
import com.MsnuJay.ReviewMS.review.ReviewRepository;
import com.MsnuJay.ReviewMS.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Boolean addReview(Long companyId, Review review) {

        if (companyId != null && review != null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public Boolean updateReview(Long reviewId, Review updatedReview) {
        Review review =reviewRepository.findById(reviewId).orElse(null);
        if (review!=null){
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setCompanyId(updatedReview.getCompanyId());
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review= reviewRepository.findById(reviewId).orElse(null);
        if (review != null){
            reviewRepository.deleteById(reviewId);
            return true;
        }
        else {
            return false;
        }
    }
}