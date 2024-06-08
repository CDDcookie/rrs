package com.cookie.review.api.request;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateReviewRequest {
    private final Long restaurantId;
    private final String content;
    private final Double score;
}
