package pdp.uz.rentcar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pdp.uz.rentcar.controller.dto.CarCategoryRequest;
import pdp.uz.rentcar.controller.dto.CarCategoryResponse;
import pdp.uz.rentcar.service.CarCategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rent-car/car-category")
public class CarCategoryController {
    private final CarCategoryService carCategoryService;

    @PostMapping("/add")
    public CarCategoryResponse createCarCategory(@RequestBody CarCategoryRequest carCategoryRequest) {
       return carCategoryService.create(carCategoryRequest);
    }

    @GetMapping("/list")
    public List<CarCategoryResponse>  getCarCategories() {
        return carCategoryService.getCarCategories();
    }

    @PostMapping("/{id}/car-category")
   public CarCategoryResponse getCarCategoryById(@PathVariable UUID id) {
      return carCategoryService.getCarCategoryById(id);
   }
}
