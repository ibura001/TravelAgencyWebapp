package application.model.dao.impl;

import application.model.dao.JdbcDao;
import application.model.entity.Order;
import application.model.entity.Tour;
import application.model.entity.User;
import application.model.exception.MySqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends JdbcDao<Order, Integer> {

    public OrderDao() throws MySqlException {
        super();
    }

    @Override
    public void save(Order order) throws MySqlException {
        String addOrder = "INSERT INTO public.order( " +
                " order_id, order_number, total_price, create_date, order_status, user_id, tour_id) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement ps = connection.prepareStatement(addOrder)) {
            ps.setLong(1, order.getId());
            ps.setString(2, order.getOrderNumber());
            ps.setInt(3, order.getTotalPrice());
            ps.setTimestamp(4, new Timestamp(new java.util.Date().getTime()));
            ps.setLong(5, order.getUser().getId());
            ps.setLong(6, order.getTour().getId());
            ps.execute();
        }catch (SQLException e){
            throw new MySqlException();
        }
    }

    @Override
    public Order getByID(Integer integer) throws MySqlException {
        String findByID = "SELECT * " +
                "FROM public.orders" +
                "INNER JOIN users ON users.user_id = orders.user_id " +
                "INNER JOIN tours ON tours.type_id = orders.tour_id " +
                "WHERE users.user_id=?;";
        Order order = null;
        try(PreparedStatement ps = connection.prepareStatement(findByID)) {
            ps.setLong(1, integer);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                order = new Order(
                        resultSet.getLong("order_id"),
                        resultSet.getString("order_number"),
                        resultSet.getInt("total_price"),
                        resultSet.getTimestamp("create_date"),
                        Order.OrderStatus.valueOf(resultSet.getString("order_status")),
                        new User(resultSet.getLong("user_id")),
                        new Tour(resultSet.getLong("tour_id"))
                );
            }
        }catch (SQLException e){
            throw new MySqlException();
        }
        return order;
    }

    @Override
    public Order getByName(Order order) throws MySqlException {
        return null;
    }


    @Override
    public List<Order> getAll() throws MySqlException {
        String findAllOrders = "SELECT * " +
                "FROM public.orders" +
                "INNER JOIN users ON users.user_id = orders.user_id " +
                "INNER JOIN tours ON tours.type_id = orders.tour_id ";

        List<Order> orders = new ArrayList<>();

        try{
            PreparedStatement ps = connection.prepareStatement(findAllOrders);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getLong("order_id"),
                        resultSet.getString("order_number"),
                        resultSet.getInt("total_price"),
                        resultSet.getTimestamp("create_date"),
                        Order.OrderStatus.valueOf(resultSet.getString("order_status")),
                        new User(resultSet.getLong("user_id")),
                        new Tour(resultSet.getLong("tour_id"))
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new MySqlException();
        }
        return orders;
    }

    @Override
    public void deleteById(Integer id) {

    }

}
