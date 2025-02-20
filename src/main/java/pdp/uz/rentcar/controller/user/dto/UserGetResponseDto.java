package pdp.uz.rentcar.controller.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGetResponseDto {
    private int userId;
    private String name;
    private String phone;
}
