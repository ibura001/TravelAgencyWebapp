package application.model.dao.impl;

import application.model.dao.JdbcDao;
import application.model.entity.User;
import application.model.exception.MySqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends JdbcDao<User, Integer> {

    public UserDao() throws MySqlException {
        super();
    }

    @Override
    public void save(User user) throws MySqlException {
/*
        String addUser = "INSERT INTO public.users( " +
                " username, password, first_name, last_name, email, phone_number, role, enable)" +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";
        // String addUser = "INSERT INTO public.users( " +
        //       " user_id, username, password, first_name, last_name, email, phone_number, role, enable)" +
        //     "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement ps = connection.prepareStatement(addUser)) {

            //ps.setLong(1, newUser.getId());
            ps.setString(1, newUser.getUsername());
            ps.setString(2, newUser.getPassword());
            ps.setString(3, newUser.getFirstName());
            ps.setString(4, newUser.getLastName());
            ps.setString(5, newUser.getEmail());
            ps.setString(6, newUser.getPhoneNumber());
            ps.setString(7, newUser.getRole().toString());
            ps.setBoolean(8, true);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
            // throw new MySqlException();
        }
        //System.out.println(newUser);
    */
    }

    @Override
    public User getByID(Integer integer) throws MySqlException {
        return null;
    }

    @Override
    public User getByName(User unauthorizedUser) throws MySqlException {
        String findByUsername = "SELECT user_id, username, password, first_name, last_name, email, phone_number, role, enable " +
                "FROM public.users " +
                "WHERE username = ?";
        User user = null;
        try(PreparedStatement ps = connection.prepareStatement(findByUsername)) {
            ps.setString(1, unauthorizedUser.getUsername());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getLong("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        User.Role.valueOf(resultSet.getString("role")),
                        resultSet.getBoolean("enable")
                );
            }
        }catch (SQLException e){
            throw new MySqlException();
        }

        return user;
    }

    @Override
    public List<User> getAll() throws MySqlException {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

}
