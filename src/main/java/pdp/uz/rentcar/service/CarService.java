package pdp.uz.rentcar.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pdp.uz.rentcar.controller.dto.CarRequest;
import pdp.uz.rentcar.controller.dto.CarResponse;
import pdp.uz.rentcar.entity.Attachment;
import pdp.uz.rentcar.entity.AttachmentContent;
import pdp.uz.rentcar.entity.Car;
import pdp.uz.rentcar.entity.CarCategory;
import pdp.uz.rentcar.entity.enums.CarStatus;
import pdp.uz.rentcar.exception.RecordNotFoundException;
import pdp.uz.rentcar.repository.AttachmentContentRepository;
import pdp.uz.rentcar.repository.AttachmentRepository;
import pdp.uz.rentcar.repository.CarCategoryRepository;
import pdp.uz.rentcar.repository.CarRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarCategoryRepository carCategoryRepository;
    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;
    private final ModelMapper modelMapper;

    public CarResponse createCar(CarRequest carRequest) throws IOException {
        Optional<CarCategory> byId = carCategoryRepository.findById(carRequest.getCarCategoryId());
        if (byId.isEmpty()) {
            throw new RecordNotFoundException("Car Category Not Found");
        }
        CarCategory carCategory = byId.get();
        Car car = Car.builder()
                .carNumber(carRequest.getCarNumber())
                .model(carRequest.getModel())
                .color(carRequest.getColor())
                .seats(carRequest.getSeats())
                .year(carRequest.getYear())
                .mileage(carRequest.getMileage())
                .carCategory(carCategory)
                .pricePerDay(carRequest.getPricePerDay())
                .transmission(carRequest.getTransmission())
                .name(carRequest.getName())
                .build();

        car.setStatus(CarStatus.AVAILABLE);
        MultipartFile file = carRequest.getFile();
        if (file != null) {
            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setContent(file.getBytes());
            attachmentContentRepository.save(attachmentContent);
            Attachment attachment = new Attachment();
            attachment.setContent(attachmentContent);
            attachment.setFilename(file.getOriginalFilename());
            attachment.setFileType(file.getContentType());
            attachment.setContent(attachmentContent);
            attachment.setFileSize(file.getSize());
            car.setAttachment(attachment);
            attachmentRepository.save(attachment);
        }
        Car save = carRepository.save(car);

        return CarResponse.builder()
                .id(save.getId())
                .name(save.getName())
                .color(save.getColor())
                .seats(save.getSeats())
                .year(save.getYear())
                .mileage(save.getMileage())
                .carCategoryName(save.getCarCategory().getName())
                .pricePerDay(save.getPricePerDay())
                .transmission(save.getTransmission())
                .carCategoryId(save.getCarCategory().getId())
                .attachmentId(save.getAttachment().getId())
                .model(save.getModel())
                .carNumber(save.getCarNumber())
                .status(save.getStatus())
                .build();
    }

    public List<CarResponse> findAllCars() {
        List<Car> all = carRepository.findAll();
        return all.stream().map(car -> modelMapper.map(car, CarResponse.class)).toList();
    }

    public CarResponse getCarById(UUID id) {
        Car carNotFound = carRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Car Not Found"));
        return modelMapper.map(carNotFound, CarResponse.class);
    }

    public void deleteCarById(UUID id) {
        carRepository.deleteById(id);
    }
}
