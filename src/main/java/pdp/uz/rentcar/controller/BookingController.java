package pdp.uz.rentcar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.rentcar.dtos.booking.request.BookingCreateRequest;
import pdp.uz.rentcar.dtos.booking.response.BookingResponse;
import pdp.uz.rentcar.service.BookingService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    private final BookingService bookingService;


    @PostMapping("/create")
    public BookingResponse create(@RequestBody BookingCreateRequest request) {
        return bookingService.create(request);
    }
}
