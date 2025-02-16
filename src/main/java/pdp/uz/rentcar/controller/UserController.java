package pdp.uz.rentcar.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pdp.uz.rentcar.controller.dto.JwtResponseDto;
import pdp.uz.rentcar.controller.dto.UserCreateRequestDto;
import pdp.uz.rentcar.entity.User;
import pdp.uz.rentcar.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    private User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/login")
    public JwtResponseDto login(@RequestBody UserCreateRequestDto request)
            throws JsonProcessingException {
        return userService.login(request.getUsername(), request.getPassword());
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

}
