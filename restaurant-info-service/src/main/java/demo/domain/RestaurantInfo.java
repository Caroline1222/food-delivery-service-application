package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestaurantInfo {

    public enum ParkingType{
        Street, Garage, Valet, PrivateLot, Validated
    }

    public enum FoodType {
        AmericanNew, AmericanTraditional, Chinese, Italian, Mediterranean, Mexican, MiddleEastern, Japanese
    }

    public enum PriceLevel{
        Inexpensive, Moderate, Pricey, UltraHighEnd
    }

    @Id
    private String restaurantId;
    private String restaurantName;
    private String restaurantPhoneNumber;
    private Point location;
    private String restaurantAddress;
    private String city;
    private String state;
    private String zip;
    private ParkingType parkingType;
    private boolean hasWifi;
    private FoodType foodType;
    private PriceLevel priceLevel;

    private List<Item> menu;

    private int hourOpen;
    private int hourClose;

    private boolean openNow;

    public RestaurantInfo() {
        this.menu = new ArrayList<>();
        this.location = new Point(0.0,0.0);
    }

    @JsonCreator
    public RestaurantInfo(@JsonProperty("restaurantName") String restaurantName,
                          @JsonProperty("menu") List<Item> menu,
                          @JsonProperty("longitude") double longitude,
                          @JsonProperty("latitude") double latitude) {
        this.restaurantName = restaurantName;
        this.menu = menu;
        this.location = new Point(longitude, latitude);
    }

    public double getLongitude(){
        return this.location.getX();
    }

    public double getLatitude(){
        return this.location.getY();
    }

}
