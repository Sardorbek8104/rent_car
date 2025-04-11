package pdp.uz.rentcar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.rentcar.dtos.review.request.ReviewCreateRequest;
import pdp.uz.rentcar.dtos.review.response.ReviewCreateResponse;
import pdp.uz.rentcar.service.ReviewService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<ReviewCreateResponse> createReview(@RequestBody ReviewCreateRequest createRequest) {
        return ResponseEntity.ok(reviewService.createReview(createRequest));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ReviewCreateResponse>> getAll() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<ReviewCreateResponse>> getByCarId(@RequestParam UUID carId) {
        return ResponseEntity.ok(reviewService.getByCarId(carId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReviewCreateResponse>> getByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(reviewService.getByUserId(userId));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable UUID reviewId) {
        reviewService.delete(reviewId);
        return ResponseEntity.noContent().build();
    }
}
