package application.model.service;

import application.model.dao.GenericDao;
import application.model.dao.JdbcDao;
import application.model.dao.impl.UserDao;
import application.model.entity.User;
import application.model.exception.*;

public class UserService {


    public User login(User unauthorizedUser) throws NoAccountException, InvalidPasswordException, BlockedUserException, MySqlException {
        UserDao dao = new UserDao();
        User user = dao.getByName(unauthorizedUser);
        if (user == null)
            throw new NoAccountException();
        else if (!user.getPassword().equals(unauthorizedUser.getPassword()))
            throw new InvalidPasswordException();
        else if (!user.isEnable()) throw new BlockedUserException();
        dao.closeConnection();
        //System.out.println(user);
        return user;
    }

    public String registration(User newUser) throws BookedUsernameException, MySqlException {
        UserDao dao = new UserDao();
        User user = dao.getByName(newUser);
        if (user == null) {
            dao.save(newUser);
            dao.closeConnection();
        } else
            throw new BookedUsernameException("User with this username already exists");

        //System.out.println(newUser);
        return "Your registration was completed!";
    }

    /*
    public static void main(String[] args) throws MySqlException {
        UserService service = new UserService();
        User newUser = new User("admin", "admin");
        service.login(newUser);
    }
    public static void main(String[] args) throws MySqlException {
        UserService service = new UserService();
        User newUser = new User("user2", "user2", "user1", "user2", "user2@gmail.com", "+380123456789", User.Role.AUTHORISED_USER, true );
        service.registration(newUser);

    }
    */

}
