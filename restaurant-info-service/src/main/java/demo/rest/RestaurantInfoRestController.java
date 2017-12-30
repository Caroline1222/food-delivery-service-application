package demo.rest;

import demo.domain.RestaurantInfo;
import demo.service.RestaurantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantInfoRestController {
    private RestaurantInfoService restaurantInfoService;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 5;

    @Autowired
    public RestaurantInfoRestController(RestaurantInfoService restaurantInfoService){
        this.restaurantInfoService = restaurantInfoService;
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RestaurantInfo> restaurantInfos){
        restaurantInfoService.savaRestaurantInfos(restaurantInfos);
    }

    @RequestMapping(value = "/restaurants/delete", method = RequestMethod.DELETE)
    public void purge(){
        restaurantInfoService.deleteAll();
    }

    @RequestMapping(value = "/restaurants/city/{city}", method = RequestMethod.GET)
    public Page<RestaurantInfo> findByCity(@PathVariable String city,
                                           @PageableDefault(page = DEFAULT_PAGE_NUMBER, size = DEFAULT_PAGE_SIZE) Pageable pageable){
        return restaurantInfoService.findByCity(city, pageable);
    }

    @RequestMapping(value = "/restaurants/type/{foodType}", method = RequestMethod.GET)
    public Page<RestaurantInfo> findByFoodType(@PathVariable String foodType,
                                               @RequestParam(name = "page") int page,
                                               @RequestParam(name = "size") int size){
        return restaurantInfoService.findByFoodType(foodType, new PageRequest(page, size));
    }

    @RequestMapping(value = "/restaurants/price/{priceLevel}", method = RequestMethod.GET)
    public Page<RestaurantInfo> findByPriceLevel(@PathVariable String priceLevel,
                                                 @RequestParam(name = "page") int page,
                                                 @RequestParam(name = "size") int size) {
        return restaurantInfoService.findByPriceLevel(priceLevel, new PageRequest(page, size));
    }
}
