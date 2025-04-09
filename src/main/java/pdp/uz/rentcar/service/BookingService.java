package pdp.uz.rentcar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pdp.uz.rentcar.repository.BookingRepository;
import pdp.uz.rentcar.repository.CarRepository;
import pdp.uz.rentcar.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;




}
