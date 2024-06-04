package com.cookie.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateAndEditRestaurantRequest {
    private final String name;
    private final String address;

    //마지막 menus같은경우는 리스트형태로 와서
    // 그 리스트안에는 객체가있음
    // CreateAndEditRestaurantRequestMnue만들어서 가져온다
    private final List<CreateAndEditRestaurantRequestMenu> menus;



}
