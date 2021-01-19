package application.model.service;

import application.model.dao.impl.TourDao;
import application.model.entity.Tour;
import application.model.exception.BookedUsernameException;
import application.model.exception.EmptyListException;
import application.model.exception.MySqlException;

import java.util.List;

public class TourService {
/*
    public String addTour(Tour newTour) throws BookedUsernameException, MySqlException {
        TourDao dao = new TourDao();
        dao.save(newTour);
        dao.closeConnection();
        System.out.println(newTour);
        return newTour +"Your Tour was completed!";
    }
*/
    public List<Tour> getAllTours() throws EmptyListException, MySqlException {
        TourDao dao = new TourDao();
        List<Tour> tours = dao.getAll();
        dao.closeConnection();
        System.out.println(tours);
        if(tours == null || tours.size()==0) throw new EmptyListException("No orders");
        return tours;
    }
    /*
    //todo getOrder
    public Tour getTour(Integer userID) throws MySQLException {
        OrderDao dao = new OrderDao();
        Order order = dao.getByID(userID);
        if(order!=null){
            System.out.println(order);
            return order;}
        else throw new NoSuchOrderException();
    }
*/

}
