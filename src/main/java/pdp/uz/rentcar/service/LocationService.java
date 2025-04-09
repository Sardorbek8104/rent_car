package pdp.uz.rentcar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pdp.uz.rentcar.dtos.location.request.LocationCreateRequest;
import pdp.uz.rentcar.dtos.location.response.LocationCreateResponse;
import pdp.uz.rentcar.entity.Location;
import pdp.uz.rentcar.repository.LocationRepository;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;


    public LocationCreateResponse create(LocationCreateRequest request) {
        Location location = new Location();
        location.setCity(request.getLocation());
        locationRepository.save(location);
        return new LocationCreateResponse(location.getId(), request.getLocation());
    }
}
