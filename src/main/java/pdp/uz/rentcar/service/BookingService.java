package pdp.uz.rentcar.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pdp.uz.rentcar.dtos.booking.request.BookingCreateRequest;
import pdp.uz.rentcar.dtos.booking.response.BookingResponse;
import pdp.uz.rentcar.entity.Booking;
import pdp.uz.rentcar.entity.enums.BookingStatus;
import pdp.uz.rentcar.repository.BookingRepository;
import pdp.uz.rentcar.repository.CarRepository;
import pdp.uz.rentcar.repository.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public BookingResponse create(BookingCreateRequest request) {
        Booking booking = new Booking();
        booking.setStatus(BookingStatus.PENDING);
        booking.setCar(carRepository.findById(request.getCarId()).orElse(null));
        booking.setUser(userRepository.findById(request.getUserId()).orElse(null));
        booking.setCreated(LocalDateTime.now());
        booking.setStartTime(request.getStartTime());
        booking.setEndTime(request.getEndTime());
        booking.setTotalPrice(request.getTotalPrice());
        bookingRepository.save(booking);
        return modelMapper.map(booking, BookingResponse.class);
    }
}
