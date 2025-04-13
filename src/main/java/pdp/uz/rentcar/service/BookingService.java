package pdp.uz.rentcar.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pdp.uz.rentcar.dtos.booking.request.BookingCreateRequest;
import pdp.uz.rentcar.dtos.booking.response.BookingResponse;
import pdp.uz.rentcar.entity.Booking;
import pdp.uz.rentcar.entity.Car;
import pdp.uz.rentcar.entity.enums.BookingStatus;
import pdp.uz.rentcar.exception.RecordNotFoundException;
import pdp.uz.rentcar.repository.BookingRepository;
import pdp.uz.rentcar.repository.CarRepository;
import pdp.uz.rentcar.repository.LocationRepository;
import pdp.uz.rentcar.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;


    public BookingResponse create(BookingCreateRequest request) {
        Booking booking = bookingRepository.save(toBooking(request));
        return modelMapper.map(booking, BookingResponse.class);
    }

    private Booking toBooking(BookingCreateRequest request) {
        Optional<Car> byId = carRepository.findById(request.getCarId());
        if (byId.isEmpty()) {
            throw new RecordNotFoundException("Car not found");
        }
        Car car = byId.get();
        Booking booking = new Booking();
        booking.setCar(car);
        booking.setUser(userRepository.findById(request.getUserId()).orElse(null));
        booking.setCreated(LocalDateTime.now());
        booking.setStartTime(request.getStartTime());
        booking.setEndTime(request.getEndTime());
        booking.setTotalPrice(request.getTotalPrice());
        booking.setStatus(BookingStatus.PENDING);
        booking.setPickupLocation(locationRepository.findById(car.getLocation().getId()).orElse(null));
        booking.setDropOffLocation(locationRepository.findById(request.getDropOffLocationId()).orElse(null));
        return booking;
    }
}
