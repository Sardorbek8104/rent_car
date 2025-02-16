package pdp.uz.rentcar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pdp.uz.rentcar.controller.dto.CarRequest;
import pdp.uz.rentcar.controller.dto.CarResponse;
import pdp.uz.rentcar.service.CarService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rent-car/cars")
public class CarController {
    private final CarService carService;
    private final ObjectMapper objectMapper;

    @PostMapping("/add")
    public CarResponse createCar(@RequestParam("car") String carJson,
                                 @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            CarRequest carRequest = objectMapper.readValue(carJson, CarRequest.class);
            carRequest.setFile(file);
            return carService.createCar(carRequest);
        } catch (Exception e) {
            throw new RuntimeException("Xatolik: JSON parse bo‘lmadi!", e);
        }
    }

    @GetMapping("/{id}/car")
    public CarResponse getCarById(@PathVariable UUID id) {
        return carService.getCarById(id);
    }

    @GetMapping("/list")
    public List<CarResponse> getCars() {
        return carService.findAllCars();
    }

    @PostMapping("/{id}/delete")
    public void deleteCarById(@PathVariable UUID id) {
        carService.deleteCarById(id);
    }

}
