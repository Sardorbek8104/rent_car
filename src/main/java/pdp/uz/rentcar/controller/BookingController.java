package pdp.uz.rentcar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pdp.uz.rentcar.dtos.booking.request.BookingCreateRequest;
import pdp.uz.rentcar.dtos.booking.response.BookingResponse;
import pdp.uz.rentcar.service.BookingService;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    private final BookingService bookingService;


    @PostMapping("/create")
    public BookingResponse create(@RequestBody BookingCreateRequest request) {
        return bookingService.create(request);
    }

    @GetMapping("/calculate-price")
    public Double calculatePrice(@RequestParam UUID carId,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        return bookingService.getTotalPrice(startTime, endTime, carId);
    }
}
