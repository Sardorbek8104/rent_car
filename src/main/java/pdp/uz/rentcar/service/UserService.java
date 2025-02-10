package pdp.uz.rentcar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.rentcar.entity.User;
import pdp.uz.rentcar.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User   create(User user) {
        return userRepository.save(user);
    }
}
