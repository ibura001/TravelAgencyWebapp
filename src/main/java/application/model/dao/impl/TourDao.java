package application.model.dao.impl;

import application.model.dao.JdbcDao;
import application.model.entity.Order;
import application.model.entity.Tour;
import application.model.entity.User;
import application.model.exception.MySqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourDao extends JdbcDao<Tour, Integer> {

    public TourDao() throws MySqlException {
        super();
    }

    @Override
    public void save(Tour tour) throws MySqlException {
        /*   String addTour = "INSERT INTO public.tours( " +
                " code, name, type, people_quantity, hotel_type, price, last_minute) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement ps = connection.prepareStatement(addTour)) {
            ps.setString(1, tour.getCode());
            ps.setString(2, tour.getName());
            Tour.Type type = Tour.Type(ps.setString(3, tour.getType().toString());
            ps.setDouble(3, tour.getDimencionID().getName());
            ps.setString(4, tour.getWeight().getName());
            ps.setString(5, tour.getDirection().getName());
            ps.setDate(6, new Date(new java.util.Date().getTime()));
            ps.execute();
        }catch (SQLException e){
            throw new MySqlException();
        }*/
    }

    @Override
    public Tour getByID(Integer integer) throws MySqlException {
        return null;
    }

    @Override
    public Tour getByName(Tour tour) throws MySqlException {
        return null;
    }


    @Override
    public List<Tour> getAll() throws MySqlException {
        String findAllTours = "SELECT * " +
                "FROM public.tours ";
        List<Tour> tours = new ArrayList<>();

        try{
            PreparedStatement ps = connection.prepareStatement(findAllTours);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                tours.add(new Tour(
                        resultSet.getLong("tour_id"),
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        Tour.Type.valueOf(resultSet.getString("type")),
                        resultSet.getInt("people_quantity"),
                        Tour.HotelType.valueOf(resultSet.getString("hotel_type")),
                        resultSet.getInt("price"),
                        resultSet.getBoolean("last_minute")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new MySqlException();
        }
        return tours;
    }

    @Override
    public void deleteById(Integer id) {

    }


}
