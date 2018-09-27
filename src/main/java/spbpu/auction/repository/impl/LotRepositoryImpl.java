package spbpu.auction.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spbpu.auction.model.Lot;
import spbpu.auction.repository.LotRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LotRepositoryImpl implements LotRepository {

    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    Connection connection;

    @Override
    public List<Lot> findAll() {
        String query = "SELECT * FROM lot";
        try {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(query);

            List<Lot> lots = new ArrayList<>();

            while (resultSet.next()) {
                final Lot lot = new Lot();
                lot.setId(resultSet.getInt("id"));
                lot.setName(resultSet.getString("name"));
                lot.setDescription(resultSet.getString("description"));
                lot.setBid(resultSet.getDouble("bid"));
                lot.setStartDate(resultSet.getDate("start_date"));
                lot.setFinishDate(resultSet.getDate("finish_date"));
                lot.setCategoryId(resultSet.getInt("category_id"));
                lot.setSellerId(resultSet.getInt("seller_id"));
                lot.setBuyerId(resultSet.getInt("buyer_id"));
                lot.setStatus(resultSet.getBoolean("status"));
                lots.add(lot);
            }
            return lots;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Lot findById(Integer integer) {
        return null;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }

    @Override
    public boolean save(Lot lot) {


        String query = "INSERT INTO lot (name, description, bid, finish_date, category_id) VALUES " +
                "('" + lot.getName() +
                "', '" + lot.getDescription() +
                "', " + lot.getBid() +
                ", '" + dateFormat.format(lot.getFinishDate()) +
                "'," + lot.getCategoryId() +
                ")";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(Lot lot) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }
}
