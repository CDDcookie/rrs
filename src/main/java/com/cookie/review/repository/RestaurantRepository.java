package com.cookie.review.repository;

import com.cookie.review.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<엔티티, id칼럼의 타입>
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
