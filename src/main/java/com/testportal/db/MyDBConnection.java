package com.testportal.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MyDBConnection {

    public static final String URL = "jdbc:mysql://localhost/";
    public static final String USER = "root";
    public static final String PASSWORD = "auf253100vbnc45";

    private Connection connection;
    public MyDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate("create database if not exists TestPortal");
        statement.executeUpdate("use TestPortal");
        statement.executeUpdate("create table if not EXISTS user(id int auto_increment PRIMARY KEY , name VARCHAR (45))");
    }

    public void saveUser(String userName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into user(name) VALUES (?)");
        ps.setString(1, userName);
        ps.executeUpdate();
    }

    public List<User> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        List<User> users = new ArrayList<User>();
        while (resultSet.next()) {

            User tempUser = User.builder()
                    .id(resultSet.getString(1))
                    .name(resultSet.getString(2))
                    .build();
            users.add(tempUser);
        }

        return users;


    }

    public User findOne(String id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user where id = ?");
        ps.setString(1, id);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        while (resultSet.next()) {
            user = User
                    .builder()
                    .id(resultSet.getString(1))
                    .name(resultSet.getString(2))
                    .build();
        }
        return user;

    }

}
