package pdp.uz.rentcar.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pdp.uz.rentcar.controller.user.converter.UserConverter;
import pdp.uz.rentcar.controller.user.dto.UserCreateRequestDto;
import pdp.uz.rentcar.controller.user.dto.UserCreateResponseDto;
import pdp.uz.rentcar.controller.user.dto.loginDto.UserLoginResponseDto;
import pdp.uz.rentcar.controller.user.dto.loginDto.UserLoginRequestDto;
import pdp.uz.rentcar.entity.User;
import pdp.uz.rentcar.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    private UserCreateResponseDto create(@RequestBody UserCreateRequestDto requestDto) {
        return UserConverter.toDto(userService.create(UserConverter.toEntity(requestDto)));
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto request)
            throws JsonProcessingException {
        return userService.login(request.getUsername(), request.getPassword());
    }

    @GetMapping("/{id}")
    public UserCreateResponseDto getUser(@PathVariable UUID id) {
        return UserConverter.toDto(userService.getUserById(id));
    }

}
