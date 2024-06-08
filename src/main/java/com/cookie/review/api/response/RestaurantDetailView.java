package com.cookie.review.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class RestaurantDetailView {
    private final Long id;
    private final String name;
    private final String address;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updateAt;

    private final List<Menu> menus;

    //추가로 mnues를 담을 필드가 필요해서 inner class
    @Builder
    @Getter
    @AllArgsConstructor
    public static class Menu{
        private final Long id;
        private final String name;
        private final Integer price;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updateAt;
    }
}
