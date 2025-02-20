package pdp.uz.rentcar.controller.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.rentcar.entity.enums.UserRole;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateResponseDto {
   private UUID id;
   private String firstName;
   private String lastName;
   private String email;
   private String username;
   private String phoneNumber;
}
