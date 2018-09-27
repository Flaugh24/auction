package spbpu.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbpu.auction.model.User;
import spbpu.auction.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password){
        final User user = userRepository.findByUsername(username);
        if(user == null)
            return false;

        return user.getPassword().equals(password);

    }

}
