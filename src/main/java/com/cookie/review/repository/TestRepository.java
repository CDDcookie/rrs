package com.cookie.review.repository;

import com.cookie.review.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long>,
TestRepositoryCustom{

    //2가지의 필드에있는걸 셀렉트해서 원하는 값을찾는 매소드만들기
    //1.JPA이용하는방법
    public List<TestEntity> findAllByName(String name);
}
