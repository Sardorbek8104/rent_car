package pdp.uz.rentcar.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarCategoryResponse {
    private UUID id;
    private String name;
}
