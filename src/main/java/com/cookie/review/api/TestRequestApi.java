package com.cookie.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRequestApi {

    @GetMapping("/test/param")
    public String requestParam(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
    ) {
        return "Hello Request Param, I am " + name + ", " + age
                ;
    }

    //Path Variable 방식 --> /test/path 이부분이 path인데 이걸 변수처럼이용
    @GetMapping("/test/path/{name}/{age}")
    public String reqestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ) {
        return "Hello, Path Variable, I am " + name + ", " + age;
    }

    // Request Body
    @PostMapping("/test/body")
    public String requestBody(
            @RequestBody TestRequestBody request
    ){
        return "Hello Request Body, I am "
                + request.name + ", " + request.age;
    }

    public static class TestRequestBody{
        String name;
        Integer age;

        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
