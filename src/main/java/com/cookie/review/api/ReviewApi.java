package com.cookie.review.api;

import com.cookie.review.api.request.CreateReviewRequest;
import com.cookie.review.service.ReviewService;
import com.cookie.review.service.dto.ReviewDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewApi {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createdReview(
            @RequestBody CreateReviewRequest request
    ) {
      reviewService.createdReview(request.getRestaurantId(), request.getContent(), request.getScore());
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ReviewDto getRestaurantReviews(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestParam("offset") Integer offset,
            @RequestParam("limit") Integer limit
    ) {
        return reviewService.getRestaurantReview(restaurantId, PageRequest.of(offset/limit, limit));
    }
}