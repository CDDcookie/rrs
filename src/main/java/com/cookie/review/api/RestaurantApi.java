package com.cookie.review.api;

import com.cookie.review.api.request.CreateAndEditRestaurantRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApi {

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "1111";
    }

    @GetMapping("restaurant/{restaurantId}")
    public String getRestaurants(
            @PathVariable Long restaurantId
    ) {
        return "2222" + restaurantId;
    }

    @PostMapping("/restaurant")
    public String createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ){
        return "This is createRestaurant, name=" + request.getName() + "address=" +request.getAddress()
            + ",menu[0].name " + request.getMenus().get(0).getName() + ", menu[0].price=" +request.getMenus().get(0).getPrice();
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ){
        return "This is editRestaurant," + restaurantId +"name " + request.getName() + "address=" + request.getAddress();
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        return "5555" + restaurantId;
    }

}
