package spbpu.auction.repository;

import java.sql.SQLException;
import java.util.List;

public interface DBRepository<T, I> {

    List<T> findAll();

    T findById(I i);

    boolean deleteById(I i);

    boolean save(T t);

    boolean delete(T t);

    long count();
}
