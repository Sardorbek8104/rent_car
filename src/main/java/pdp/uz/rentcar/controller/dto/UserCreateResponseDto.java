package pdp.uz.rentcar.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pdp.uz.rentcar.entity.enums.UserRole;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class UserCreateResponseDto {
    private int id;
    private String username;
    private List<UserRole> roles;
}
