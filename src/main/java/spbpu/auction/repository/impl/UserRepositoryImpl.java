package spbpu.auction.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spbpu.auction.model.User;
import spbpu.auction.repository.UserRepository;

import java.sql.*;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    Connection connection;

    @Override
    public User findByUsername(String username) {

        String query = "SELECT * FROM users WHERE email = '" + username + "'";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next())
                return null;

            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setSecondName(resultSet.getString("second_name"));

            if(resultSet.next())
                throw new SQLException();

            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public long count() {

        String query = "SELECT count(*) FROM users";
        try {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return resultSet.getLong("count");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
