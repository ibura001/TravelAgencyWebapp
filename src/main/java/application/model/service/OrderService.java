package application.model.service;

import application.model.dao.impl.OrderDao;
import application.model.entity.Order;
import application.model.exception.BookedUsernameException;
import application.model.exception.EmptyListException;
import application.model.exception.MySqlException;
import application.model.exception.NoSuchOrderException;

import java.util.List;

public class OrderService {

    public String addOrder(Order newOrder) throws BookedUsernameException, MySqlException {
        OrderDao dao = new OrderDao();
        dao.save(newOrder);
        dao.closeConnection();
        System.out.println(newOrder);
        return newOrder + "Your order was completed!";
    }

    public List<Order> getAllOrders() throws EmptyListException, MySqlException {
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.getAll();
        dao.closeConnection();
        System.out.println(orders);
        if(orders == null|| orders.size()==0) throw new EmptyListException("No orders");
        return orders;
    }
    //todo getOrder
    public Order getOrder(Integer userID) throws MySqlException {
        OrderDao dao = new OrderDao();
        Order order = dao.getByID(userID);
        if(order!=null){
            System.out.println(order);
            return order;}
        else throw new NoSuchOrderException();
    }

}
