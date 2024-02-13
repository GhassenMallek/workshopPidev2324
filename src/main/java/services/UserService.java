package services;

import models.User;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IService<User> {

    private Connection connection;

    public UserService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void add(User user) throws SQLException {
        String sql = "insert into user (name,age) VALUES ('"+user.getName() +"',"+ user.getAge()+")";
        System.out.println(sql);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "update user set name = ?,  age = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(2, user.getName());
        preparedStatement.setInt(3, user.getAge());
        preparedStatement.setInt(1, user.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<User> getAll() throws SQLException {
        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setAge(rs.getInt("age"));
            u.setName(rs.getString("name"));

            users.add(u);
        }
        return users;
    }

    @Override
    public User getById(int idUser) throws SQLException {
        String sql = "SELECT `name`, `age` FROM `user` WHERE `id` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idUser);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            return new User(idUser, age, name);
        } else {
            // Handle the case when no matching record is found
            return null;
        }

    }
}
