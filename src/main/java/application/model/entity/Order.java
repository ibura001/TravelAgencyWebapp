package application.model.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Order {

    private Long id;
    private String orderNumber;
    private Integer totalPrice;
    private Timestamp createDate;
    private OrderStatus orderStatus;
    private User user;
    private Tour tour;


    public enum OrderStatus {
        BOOKED,
        PAID,
        CANCELED;
    }

    public Order(Long id, String orderNumber, Integer totalPrice, Timestamp createDate, OrderStatus orderStatus, User user, Tour tour) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
        this.orderStatus = orderStatus;
        this.user = user;
        this.tour = tour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return Objects.equals(id, order.id) &&
                Objects.equals(orderNumber, order.orderNumber) &&
                Objects.equals(totalPrice, order.totalPrice) &&
                Objects.equals(createDate, order.createDate) &&
                orderStatus == order.orderStatus &&
                Objects.equals(user, order.user) &&
                Objects.equals(tour, order.tour);
    }

    @Override
    public String toString() {
        return "Order {" +
                " id = " + id +
                ",\n\t order number = '" + orderNumber +
                "',\n\t total price = " + totalPrice +
                ",\n\t create date = '" + createDate +
                "', order status = '" + orderStatus +
                "',\n\t user = '" + user +
                "', tour = '" + tour +
                "'}";
    }

}
