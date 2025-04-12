package pdp.uz.rentcar.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pdp.uz.rentcar.mapper.UserConverter;
import pdp.uz.rentcar.dtos.user.request.UserCreateRequest;
import pdp.uz.rentcar.dtos.user.response.UserResponse;
import pdp.uz.rentcar.entity.User;
import pdp.uz.rentcar.service.UserService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    private UserResponse create(@RequestBody @Valid UserCreateRequest requestDto) {
        User entity = UserConverter.toEntity(requestDto);
        User user = userService.create(entity);
        return UserConverter.toDto(user);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable UUID id) {
        return UserConverter.toDto(userService.getUserById(id));
    }


    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
      return userService.getAllUsers().stream().map(UserConverter::toDto).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable("id") UUID id) {
       return  userService.deleteUserById(id);
    }


}
