package pdp.uz.rentcar.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pdp.uz.rentcar.mapper.UserConverter;
import pdp.uz.rentcar.dtos.user.request.UserCreateRequest;
import pdp.uz.rentcar.dtos.user.response.UserCreateResponse;
import pdp.uz.rentcar.dtos.user.request.UserLoginRequest;
import pdp.uz.rentcar.dtos.user.response.UserLoginResponse;
import pdp.uz.rentcar.entity.User;
import pdp.uz.rentcar.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    private UserCreateResponse create(@RequestBody @Valid UserCreateRequest requestDto) {
        User entity = UserConverter.toEntity(requestDto);
        User user = userService.create(entity);
        return UserConverter.toDto(user);
    }

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody @Valid UserLoginRequest request)
            throws JsonProcessingException {
        return userService.login(request.getUsername(), request.getPassword());
    }

    @GetMapping("/{id}")
    public UserCreateResponse getUser(@PathVariable UUID id) {
        return UserConverter.toDto(userService.getUserById(id));
    }


}
