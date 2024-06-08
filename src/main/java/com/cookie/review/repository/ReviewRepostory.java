package com.cookie.review.repository;

import com.cookie.review.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepostory extends JpaRepository<ReviewEntity, Long> {

}
