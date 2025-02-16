package pdp.uz.rentcar.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.rentcar.entity.enums.CarStatus;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarResponse {
    private UUID id;
    private String name;
    private String model;
    private String carNumber;
    private String color;
    private String transmission;
    private String mileage;
    private int seats;
    private String year;
    private double pricePerDay;
    private UUID carCategoryId;
    private String carCategoryName;
    private UUID attachmentId;
    private CarStatus status;
}
