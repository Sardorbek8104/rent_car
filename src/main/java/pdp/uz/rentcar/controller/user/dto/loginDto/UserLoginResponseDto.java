package pdp.uz.rentcar.controller.user.dto.loginDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoginResponseDto {
    private String accessToken;
    private String refreshToken;

    public UserLoginResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
