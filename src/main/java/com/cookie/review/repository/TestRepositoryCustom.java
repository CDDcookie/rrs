package com.cookie.review.repository;

import com.cookie.review.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TestRepositoryCustom                  {
    public List<TestEntity> findAllByNameByQuerydsl(String name);
}
