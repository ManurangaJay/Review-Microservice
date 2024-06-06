package com.MsnuJay.ReviewMS.review;

import java.util.List;

public interface ReviewService {
    List<Review>  getAllReviews(Long companyId);
    Boolean addReview(Long companyId, Review review);
    Review getReviewById(Long reviewId);
    Boolean updateReview(Long reviewId , Review review);

    boolean deleteReview(Long reviewId);
}
