package com.cookie.review.service;

import com.cookie.review.api.request.CreateAndEditRestaurantRequest;
import com.cookie.review.api.response.RestaurantDetailView;
import com.cookie.review.api.response.RestaurantView;
import com.cookie.review.model.MenuEntity;
import com.cookie.review.model.RestaurantEntity;
import com.cookie.review.repository.MenuRepository;
import com.cookie.review.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public RestaurantEntity createRestaurant(
           CreateAndEditRestaurantRequest request
    ) {
//  RestaurantEntity restaurant = new RestaurantEntity(); //->빌더로 만들어보기
    RestaurantEntity restaurant = RestaurantEntity.builder()
            .name(request.getName())
            .address(request.getAddress())
            .createdAt(ZonedDateTime.now())
            .updateAt(ZonedDateTime.now())
            .build();
        restaurantRepository.save(restaurant);//레스토랑을 세이브한이후에

        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())//레스트랑아이디를 가져옴
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updateAt(ZonedDateTime.now())
                    .build();

            menuRepository.save(menuEntity);

        });
        restaurantRepository.save(restaurant);
    return restaurant;
    }

    @Transactional
    public void editRestaurant(
            Long restaurantId,
            CreateAndEditRestaurantRequest request
    ) {
        RestaurantEntity restaurant =
        restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("없는레스토랑 입니다."));
        restaurant.changeNameAndAddress(request.getName(), request.getAddress());
        restaurantRepository.save(restaurant);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);

        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurantId)
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updateAt(ZonedDateTime.now())
                    .build();
            menuRepository.save(menuEntity);
        });


    }

    @Transactional
    public void deleteRestaurant(Long restaurantId) {
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        restaurantRepository.delete(restaurant);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);

    }

    public List<RestaurantView> getAllRestaurant(){
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();

        //findAll() 한걸 RestaurantView로 바꿔서 리턴을해줘야하해서
        return restaurants.stream().map((restaurant) -> RestaurantView.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .createdAt(restaurant.getCreatedAt())
                .updateAt(restaurant.getUpdateAt())
                .build()
        ).toList();

    }

    public RestaurantDetailView getRestaurantDetailView(Long restaurnatId){
        RestaurantEntity restaurant = restaurantRepository.findById(restaurnatId).orElseThrow();
        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurnatId);

        return RestaurantDetailView.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .updateAt(restaurant.getUpdateAt())
                .createdAt(restaurant.getCreatedAt())
                .menus(
                        menus.stream().map((menu) -> RestaurantDetailView.Menu.builder()
                                        .id(menu.getId())
                                        .name(menu.getName())
                                        .price(menu.getPrice())
                                        .createdAt(menu.getCreatedAt())
                                        .updateAt(menu.getUpdateAt())
                                        .build()
                        ).toList()
                ).build();
    }

}
