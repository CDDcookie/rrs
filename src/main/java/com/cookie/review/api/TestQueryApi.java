package com.cookie.review.api;

import com.cookie.review.model.TestEntity;
import com.cookie.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestQueryApi {
    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJpa(){
        return testService.findAllByNameByJPA("jinwoo");
    }

    @GetMapping("/test/query/querydsl")
    public List<TestEntity> querydsl(){
        return testService.findAllByNameByQuerydsl("jinwoo");
    }
}
