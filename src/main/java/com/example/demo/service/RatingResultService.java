package com.example.demo.service;

import com.example.demo.entity.RatingResult;
import java.util.List;

public interface RatingResultService {
    RatingResult createRatingResult(RatingResult ratingResult);
    RatingResult getRatingResultById(Long id);
    List<RatingResult> getAllRatingResults();
    RatingResult updateRatingResult(Long id, RatingResult ratingResult);
    void deleteRatingResult(Long id);
}
