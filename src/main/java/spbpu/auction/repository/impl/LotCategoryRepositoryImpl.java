package spbpu.auction.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spbpu.auction.model.Lot;
import spbpu.auction.model.LotCategory;
import spbpu.auction.repository.LotCategoryRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LotCategoryRepositoryImpl implements LotCategoryRepository {

    @Autowired
    Connection connection;

    @Override
    public List<LotCategory> findAll() {

        String query = "SELECT * FROM lot_category";
        try {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(query);

            List<LotCategory> categories= new ArrayList<>();

            while (resultSet.next()) {
                final LotCategory lotCategory = new LotCategory();
                lotCategory.setId(resultSet.getInt("id"));
                lotCategory.setName(resultSet.getString("name"));
                categories.add(lotCategory);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public LotCategory findById(Integer integer) {
        return null;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }

    @Override
    public boolean save(LotCategory lotCategory) {
        return false;
    }

    @Override
    public boolean delete(LotCategory lotCategory) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }
}
