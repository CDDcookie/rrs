package com.cookie.review.repository;

import com.cookie.review.model.QReviewEntity;
import com.cookie.review.model.ReviewEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    @Override
    public Double getAvgScoreByRestaurantId(Long restaurantId) {
        return queryFactory.select(QReviewEntity.reviewEntity.score.avg())
        //=리뷰엔티티의 점수 평균을 낸다
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                .fetchFirst();
    }

    @Override
    public Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable page) {
        List<ReviewEntity> reviews = queryFactory.select(QReviewEntity.reviewEntity)
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                //맛집에 등록된 리뷰들을 가져왔다
                .offset((long) page.getPageNumber() * page.getPageSize())//page.getPageNumber()는 0,1,2,처럼증가하는값
                //offset은 (10개가져오라하면) 0번부터 9번까지 가져오는것
                .limit(page.getPageSize() + 1) //Slice를 리턴할땐 +1을한다
                //페이지사이즈에 1개를 더 가져온다음에
                .fetch();

        return new SliceImpl<>(
                reviews.stream().limit(page.getPageSize()).toList(),
                page,
                reviews.size() > page.getPageSize()
                //10개를 가져오라했을때 11개를 가져올수있다면 너는 다음페이지도 호출할수있다
                );
    }
}

