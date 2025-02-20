package pdp.uz.rentcar.controller.user.dto.loginDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDto {
    private String username;
    private String password;
}
