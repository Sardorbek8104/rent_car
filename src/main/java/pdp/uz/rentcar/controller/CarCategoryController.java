package pdp.uz.rentcar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pdp.uz.rentcar.dtos.carCategory.request.CarCategoryRequest;
import pdp.uz.rentcar.dtos.carCategory.request.CarCategoryUpdateRequest;
import pdp.uz.rentcar.dtos.carCategory.response.CarCategoryResponse;
import pdp.uz.rentcar.service.CarCategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car-category")
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

    @PostMapping("/car-category/{id}")
   public CarCategoryResponse getCarCategoryById(@PathVariable UUID id) {
      return carCategoryService.getCarCategoryById(id);
   }
   @DeleteMapping("/delete/{id}")
   public boolean deleteCarCategoryById(@PathVariable UUID id) {
        return carCategoryService.deleteCarCategoryById(id);
   }

   @PutMapping("/update")
   private CarCategoryResponse update(@RequestBody CarCategoryUpdateRequest carCategoryUpdateRequest) {
      return   carCategoryService.update(carCategoryUpdateRequest);
   }
}
