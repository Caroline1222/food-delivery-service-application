package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import static demo.domain.RestaurantInfo.FoodType;
import static demo.domain.RestaurantInfo.PriceLevel;

@RepositoryRestResource(path = "restaurants")
public interface RestaurantInfoRepository extends PagingAndSortingRepository<RestaurantInfo, String> {
    @RestResource(path = "city")
    Page<RestaurantInfo> findByCity(@Param("city") String city, Pageable pageable);
    @RestResource(path = "type")
    Page<RestaurantInfo> findByFoodType(@Param("foodType") FoodType foodType, Pageable pageable);
    @RestResource(path = "price")
    Page<RestaurantInfo> findByPriceLevel(@Param("priceLevel") PriceLevel priceLevel, Pageable pageable);
    void deleteByRestaurantName(String restaurantName);
}
