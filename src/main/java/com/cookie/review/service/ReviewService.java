package com.cookie.review.service;

import com.cookie.review.model.ReviewEntity;
import com.cookie.review.repository.RestaurantRepository;
import com.cookie.review.repository.ReviewRepostory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor

public class ReviewService {
    private final ReviewRepostory reviewRepostory;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void createdReview(Long restaurnatId, String content, Double score) {
        restaurantRepository.findById(restaurnatId).orElseThrow();

        ReviewEntity review = ReviewEntity.builder()
                .restaurantId(restaurnatId)
                .content(content)
                .score(score)
                .createdAt(ZonedDateTime.now())
                .build();
        reviewRepostory.save(review);
    }

    @Transactional
    public void deleteReview(Long reviewId) {
        ReviewEntity review = reviewRepostory.findById(reviewId).orElseThrow();

        reviewRepostory.delete(review);
    }
}
