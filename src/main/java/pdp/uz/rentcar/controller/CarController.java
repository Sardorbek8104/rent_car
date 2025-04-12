package pdp.uz.rentcar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pdp.uz.rentcar.dtos.car.request.CarCreateRequest;
import pdp.uz.rentcar.dtos.car.response.CarCreateResponse;
import pdp.uz.rentcar.service.CarService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarService carService;
    private final ObjectMapper objectMapper;

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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

    @GetMapping("/car/{id}")
    public CarCreateResponse getCarById(@PathVariable UUID id) {
        return carService.getCarById(id);
    }

    @GetMapping("/list")
    public List<CarCreateResponse> getCars() {
        return carService.findAllCars();
    }

    @PostMapping("/delete/{id}")
    public void deleteCarById(@PathVariable UUID id) {
        carService.deleteCarById(id);
    }


    @GetMapping("/search")
    public ResponseEntity<List<CarCreateResponse>> searchCars(
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer year
    ) {
        List<CarCreateResponse> result = carService.searchCars(model, minPrice, maxPrice, year);
        return ResponseEntity.ok(result);
    }


}
