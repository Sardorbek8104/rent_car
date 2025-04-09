package pdp.uz.rentcar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pdp.uz.rentcar.dtos.car.request.CarCreateRequest;
import pdp.uz.rentcar.dtos.car.response.CarCreateResponse;
import pdp.uz.rentcar.service.CarService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/rent-car/cars")
public class CarController {
    private final CarService carService;
    private final ObjectMapper objectMapper;

    @PostMapping("/add")
    public CarCreateResponse createCar(@RequestParam("car") String carJson,
                                       @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            CarCreateRequest carRequest = objectMapper.readValue(carJson, CarCreateRequest.class);
            carRequest.setFile(file);
            return carService.createCar(carRequest);
        } catch (Exception e) {
            throw new RuntimeException("Xatolik: JSON parse bo‘lmadi!", e);
        }
    }

    @GetMapping("/{id}/car")
    public CarCreateResponse getCarById(@PathVariable UUID id) {
        return carService.getCarById(id);
    }

    @GetMapping("/list")
    public List<CarCreateResponse> getCars() {
        return carService.findAllCars();
    }

    @PostMapping("/{id}/delete")
    public void deleteCarById(@PathVariable UUID id) {
        carService.deleteCarById(id);
    }

}
