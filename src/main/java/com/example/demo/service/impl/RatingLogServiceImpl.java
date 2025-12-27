


   
   package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RatingLogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingLogServiceImpl implements RatingLogService {
    private final RatingLogRepository logRepository;
    private final PropertyRepository propertyRepository;

    public RatingLogServiceImpl(RatingLogRepository lr, PropertyRepository pr) {
        this.logRepository = lr; this.propertyRepository = pr;
    }

    @Override
    public RatingLog addLog(Long propertyId, String message) {
        Property p = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        RatingLog log = new RatingLog();
        log.setProperty(p);
        log.setMessage(message);
        return logRepository.save(log);
    }

    @Override
    public List<RatingLog> getLogsByProperty(Long propertyId) {
        Property p = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return logRepository.findByProperty(p);
    }
}
