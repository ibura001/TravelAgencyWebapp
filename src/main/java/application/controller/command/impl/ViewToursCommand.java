package application.controller.command.impl;


import application.controller.util.Pagination;
import application.model.entity.Tour;
import application.model.exception.EmptyListException;
import application.model.exception.MySqlException;
import application.model.service.TourService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewToursCommand extends AbstractCommand{

    private TourService service;

    public ViewToursCommand() {
        this.service = new TourService();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Tour> tours = service.getAllTours();
            for (Tour tour: tours
            ) {
                System.out.println(tour);
            }

        new Pagination().configure(request, 3, "tours", tours);
        } catch (EmptyListException e) {
            setErrorRequest(request, response, e.getMessage(), "/TravelAgencyWebapp_war/userTours");
        } catch (MySqlException e) {
            setErrorRequest(request, response, e.getMessage(), "/TravelAgencyWebapp_war/userTours");
        }
        return "/jsp/user/tours.jsp";
    }


}
