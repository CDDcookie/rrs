package com.cookie.review.api;

import com.cookie.review.api.request.CreateAndEditRestaurantRequest;
import com.cookie.review.api.response.RestaurantDetailView;
import com.cookie.review.api.response.RestaurantView;
import com.cookie.review.model.RestaurantEntity;
import com.cookie.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor // 생성자 주입을 임의의 코드없이 자동으로 설정
@RestController
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants() {
//        return List.of(RestaurantView.builder()
//                .id(0L)
//                .name("test name")
//                .address("test address")
//                .createdAt(ZonedDateTime.now())
//                .updateAt(ZonedDateTime.now())
//                .build());
        return  restaurantService.getAllRestaurant();
    }

    @GetMapping("restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurants(
            @PathVariable Long restaurantId
    ) {
//        return RestaurantDetailView.builder()
//                .id(0L)
//                .name("test name")
//                .address("test address")
//                .createdAt(ZonedDateTime.now())
//                .updateAt(ZonedDateTime.now())
//                .menus(List.of(
//                        RestaurantDetailView.Menu.builder()
//                                .id(0L)
//                                .name("test name")
//                                .price(500)
//                                .createdAt(ZonedDateTime.now())
//                                .updateAt(ZonedDateTime.now())
//                                .build()
//                ))
//                .build();
        return restaurantService.getRestaurantDetailView(restaurantId);
    }

    @PostMapping("/restaurant")
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ){
//        return "This is createRestaurant, name=" + request.getName() + "address=" +request.getAddress()
//            + ",menu[0].name " + request.getMenus().get(0).getName() + ", menu[0].price=" +request.getMenus().get(0).getPrice();
    restaurantService.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
            //CreateAndEditRestaurantRequest 에는 이름+주소있음
    ){
        restaurantService.editRestaurant(restaurantId, request);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        restaurantService.deleteRestaurant(restaurantId);
    }

}
