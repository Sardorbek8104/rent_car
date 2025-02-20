package pdp.uz.rentcar.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pdp.uz.rentcar.controller.carCategory.dto.CarCategoryRequest;
import pdp.uz.rentcar.controller.carCategory.dto.CarCategoryResponse;
import pdp.uz.rentcar.entity.CarCategory;
import pdp.uz.rentcar.exception.RecordNotFoundException;
import pdp.uz.rentcar.repository.CarCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarCategoryService {
    private  final CarCategoryRepository carCategoryRepository;
    private  final ModelMapper modelMapper;

    public CarCategoryResponse create(CarCategoryRequest carCategoryRequest) {
        CarCategory carCategory = modelMapper.map(carCategoryRequest, CarCategory.class);
        CarCategory save = carCategoryRepository.save(carCategory);
        return modelMapper.map(save, CarCategoryResponse.class);
    }

    public CarCategoryResponse getCarCategoryById(UUID id) {
        Optional<CarCategory> carCategory = carCategoryRepository.findById(id);
        if (carCategory.isEmpty()){
            throw new RecordNotFoundException("Car Category Not Found");
        }
        return modelMapper.map(carCategory.get(), CarCategoryResponse.class);
    }

    public List<CarCategoryResponse> getCarCategories() {
        List<CarCategory> carCategories = carCategoryRepository.findAll();
       return carCategories.stream().map(carCategory -> modelMapper.map( carCategory, CarCategoryResponse.class)).toList();
    }

}
