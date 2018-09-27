package spbpu.auction.repository;

import spbpu.auction.model.User;

public interface UserRepository extends DBRepository<User, Integer> {

    User findByUsername(String username);

}
