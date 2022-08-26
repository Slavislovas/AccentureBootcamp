package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DataController {
    private Connection connection;

    public DataController(Connection connection){
        this.connection = connection;
    }

    public boolean checkLogin(String login, String password) {
        String sql = String.format("SELECT * FROM users WHERE login='%s' AND password='%s'", login, password);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return true;
            } else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertUser(String login, String password) {
        String sql = String.format("INSERT INTO users VALUES('%s', '%s')", login, password);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
