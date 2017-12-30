package demo.service.impl;

import demo.domain.RestaurantInfo;
import demo.domain.RestaurantInfoRepository;
import demo.service.RestaurantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService {

    private RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    public RestaurantInfoServiceImpl(RestaurantInfoRepository restaurantInfoRepository){
        this.restaurantInfoRepository = restaurantInfoRepository;
    }

    @Override
    public List<RestaurantInfo> savaRestaurantInfos(List<RestaurantInfo> restaurantInfos) {
        return (ArrayList<RestaurantInfo>)restaurantInfoRepository.save(restaurantInfos);
    }

    @Override
    public void deleteByRestaurantName(String restaurantName) {
        restaurantInfoRepository.deleteByRestaurantName(restaurantName);
    }

    @Override
    public void deleteAll() {
        restaurantInfoRepository.deleteAll();
    }

    @Override
    public Page<RestaurantInfo> findByCity(String city, Pageable pageable) {
        return restaurantInfoRepository.findByCity(city, pageable);
    }

    @Override
    public Page<RestaurantInfo> findByFoodType(String foodType, Pageable pageable) {
        return restaurantInfoRepository.findByFoodType(RestaurantInfo.FoodType.valueOf(foodType), pageable);
    }

    @Override
    public Page<RestaurantInfo> findByPriceLevel(String priceLevel, Pageable pageable) {
        return restaurantInfoRepository.findByPriceLevel(RestaurantInfo.PriceLevel.valueOf(priceLevel), pageable);
    }
}
