package demo.service;

import demo.domain.RestaurantInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantInfoService {

    List<RestaurantInfo> savaRestaurantInfos(List<RestaurantInfo> restaurantInfos);

    void deleteByRestaurantName(String restaurantName);

    void deleteAll();

    Page<RestaurantInfo> findByCity(String city, Pageable pageable);
    Page<RestaurantInfo> findByFoodType(String foodType, Pageable pageable);
    Page<RestaurantInfo> findByPriceLevel(String priceLevel, Pageable pageable);

}
