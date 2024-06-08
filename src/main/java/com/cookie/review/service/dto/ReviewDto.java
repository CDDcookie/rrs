package com.cookie.review.service.dto;

import com.cookie.review.model.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ReviewDto {
    private Double avgScore;
    private List<ReviewEntity> reviews;
    private ReviewDtoPage page;

    @Getter
    @AllArgsConstructor
    @Builder
    public static class ReviewDtoPage{
        private Integer offset;
        private Integer limit;
    }
}
