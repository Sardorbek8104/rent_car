package pdp.uz.rentcar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.rentcar.dtos.location.request.LocationCreateRequest;
import pdp.uz.rentcar.dtos.location.response.LocationCreateResponse;
import pdp.uz.rentcar.service.LocationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/location")
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/create")
    private LocationCreateResponse create(@RequestBody LocationCreateRequest request) {
        return locationService.create(request);
    }
}
