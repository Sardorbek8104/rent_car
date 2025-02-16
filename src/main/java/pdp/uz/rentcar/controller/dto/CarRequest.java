package pdp.uz.rentcar.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarRequest {
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
    private MultipartFile file;
}
