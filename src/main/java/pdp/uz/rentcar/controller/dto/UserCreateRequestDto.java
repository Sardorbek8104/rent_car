package pdp.uz.rentcar.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateRequestDto {
    private String username;
    private String password;
}
