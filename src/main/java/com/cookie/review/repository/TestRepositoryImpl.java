package com.cookie.review.repository;


import com.cookie.review.model.QTestEntity;
import com.cookie.review.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TestRepositoryImpl implements TestRepositoryCustom
{

    private final JPAQueryFactory queryFactory;
    //   ㄴ>QuerydslConfig에서
    //    @Bean
    //    public JPAQueryFactory queryFactory(){
    //        return new JPAQueryFactory(em);
    //    } -->이걸 가져오는것
    @Override
    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return queryFactory.selectFrom(QTestEntity.testEntity)
                .fetch();
    }


}
