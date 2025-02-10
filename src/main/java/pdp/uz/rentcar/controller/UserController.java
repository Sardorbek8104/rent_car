package pdp.uz.rentcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.rentcar.entity.User;
import pdp.uz.rentcar.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    private User create(@RequestBody User user) {
        return userService.create(user);
    }
}
