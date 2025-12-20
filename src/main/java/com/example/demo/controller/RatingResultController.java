package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.RatingResultRequest;
import com.example.demo.dto.RatingResultResponse;
import com.example.demo.entity.RatingResult;
import com.example.demo.entity.Property;
import com.example.demo.service.RatingResultService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rating-results")
public class RatingResultController {

    @Autowired
    private RatingResultService ratingResultService;

    @PostMapping
    public ResponseEntity<RatingResultResponse> create(@RequestBody RatingResultRequest request) {
        RatingResult ratingResult = new RatingResult();
        Property property = new Property();
        property.setId(request.getPropertyId());
        ratingResult.setProperty(property);
        ratingResult.setFinalRating(request.getFinalRating());
        ratingResult.setRatingCategory(request.getRatingCategory());

        RatingResult saved = ratingResultService.createRatingResult(ratingResult);

        RatingResultResponse response = mapToResponse(saved);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingResultResponse> getById(@PathVariable Long id) {
        RatingResult ratingResult = ratingResultService.getRatingResultById(id);
        return ResponseEntity.ok(mapToResponse(ratingResult));
    }

    @GetMapping
    public ResponseEntity<List<RatingResultResponse>> getAll() {
        List<RatingResultResponse> list = ratingResultService.getAllRatingResults()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatingResultResponse> update(@PathVariable Long id, @RequestBody RatingResultRequest request) {
        RatingResult ratingResult = new RatingResult();
        ratingResult.setFinalRating(request.getFinalRating());
        ratingResult.setRatingCategory(request.getRatingCategory());

        RatingResult updated = ratingResultService.updateRatingResult(id, ratingResult);
        return ResponseEntity.ok(mapToResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ratingResultService.deleteRatingResult(id);
        return ResponseEntity.noContent().build();
    }

    private RatingResultResponse mapToResponse(RatingResult ratingResult) {
        RatingResultResponse response = new RatingResultResponse();
        response.setId(ratingResult.getId());
        response.setPropertyId(ratingResult.getProperty().getId());
        response.setFinalRating(ratingResult.getFinalRating());
        response.setRatingCategory(ratingResult.getRatingCategory());
        response.setCalculatedAt(ratingResult.getCalculatedAt());
        return response;
    }
}
