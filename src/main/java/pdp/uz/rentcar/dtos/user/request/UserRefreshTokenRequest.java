package pdp.uz.rentcar.dtos.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRefreshTokenRequest {
    private String refreshToken;
}
