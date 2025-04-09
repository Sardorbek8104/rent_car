package pdp.uz.rentcar.dtos.user.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoginResponse {
    private String accessToken;
    private String refreshToken;

    public UserLoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
