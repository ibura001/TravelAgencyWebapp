package application.model.entity;

import java.util.Objects;

public class Tour {

    private Long id;
    private String code;
    private String name;
    private Type type;
    private Integer peopleQuantity;
    private HotelType hotelType;
    private Integer price;
    private Boolean lastMinute;

    public enum Type {
        SHOPPING,
        SIGHTSEEING,
        SPORT,
        ADVENTURE,
        FOOD,
        EXCURSION,
        CULTURAL,
        CRUISING,
        VACATION,
        HONEYMOON,
        FAMILY;
    }

    public enum HotelType {
        ONE_STAR,
        TWO_STAR,
        THREE_STAR,
        FOUR_STAR,
        FIVE_STAR;
    }

    public Tour(Long tourId){
        this.id = tourId;
    }

    public Tour(Long id, String code, String name, Type type, Integer peopleQuantity,
                HotelType hotelType, Integer price, Boolean lastMinute) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.peopleQuantity = peopleQuantity;
        this.hotelType = hotelType;
        this.price = price;
        this.lastMinute = lastMinute;
    }

    public Tour(String code, String name, Type type, Integer peopleQuantity,
                HotelType hotelType, Integer price, Boolean lastMinute) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.peopleQuantity = peopleQuantity;
        this.hotelType = hotelType;
        this.price = price;
        this.lastMinute = lastMinute;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getPeopleQuantity() {
        return peopleQuantity;
    }

    public void setPeopleQuantity(Integer peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    public void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getLastMinute() {
        return lastMinute;
    }

    public void setLastMinute(Boolean lastMinute) {
        this.lastMinute = lastMinute;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tour tour = (Tour) obj;
        return Objects.equals(id, tour.id) &&
                Objects.equals(code, tour.code) &&
                Objects.equals(name, tour.name) &&
                type == tour.type &&
                Objects.equals(peopleQuantity, tour.peopleQuantity) &&
                hotelType == tour.hotelType &&
                Objects.equals(price, tour.price) &&
                Objects.equals(lastMinute, tour.lastMinute);
    }

    @Override
    public String toString() {
        return "Tour {" +
                " id = " + id +
                ",\n\t code = '" + code +
                "', name = '" + name +
                "',\n\t type = '" + type +
                "',\n\t people quantity = " + peopleQuantity +
                ",\n\t hotel type = '" + hotelType +
                "',\n\t price = " + price +
                ", last minute = " + lastMinute +
                "}";
    }

}
