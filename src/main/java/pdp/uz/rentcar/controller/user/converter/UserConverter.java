package pdp.uz.rentcar.controller.user.converter;

import pdp.uz.rentcar.controller.user.dto.UserCreateRequestDto;
import pdp.uz.rentcar.controller.user.dto.UserCreateResponseDto;
import pdp.uz.rentcar.entity.User;

public class UserConverter {
    public static User toEntity(UserCreateRequestDto requestDto) {
        User user = new User();
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setEmail(requestDto.getEmail());
        user.setUsername(requestDto.getUsername());
        user.setPassword(requestDto.getPassword());
        user.setPhoneNumber(requestDto.getPhoneNumber());
        return user;
    }
    public static UserCreateResponseDto toDto(User user) {
        UserCreateResponseDto dto = new UserCreateResponseDto();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }
}
