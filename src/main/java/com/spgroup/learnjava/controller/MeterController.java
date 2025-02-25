package com.spgroup.learnjava.controller;

import org.springframework.web.bind.annotation.*;
import com.spgroup.learnjava.model.MeterReading;
import com.spgroup.learnjava.mapper.MeterReadingMapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MeterController {

    @Autowired
    private MeterReadingMapper meterReadingMapper;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/meter-reading")
    public Map<String, Object> addMeterReading(@RequestBody MeterReading meterReading) {
        Map<String, Object> response = new HashMap<>();
        try {
            meterReadingMapper.insert(meterReading);
            response.put("status", 200);
            response.put("message", "Reading added successfully");
        } catch (Exception e) {
            response.put("status", 500);
            response.put("message", "Failed to add reading: " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/get-meter-reading")
    public Map<String, Object> getMeterReading(@RequestParam String meterID) {
        Map<String, Object> response = new HashMap<>();
        try {
            Double sum_reading = meterReadingMapper.getReadingSum(meterID);
            if (sum_reading != null) {
                response.put("status", 200);
                response.put("reading", sum_reading);
            } else {
                response.put("status", 404);
                response.put("message", "No readings found for meter ID: " + meterID);
            }
        } catch (Exception e) {
            response.put("status", 500);
            response.put("message", "Failed to get reading: " + e.getMessage());
        }
        return response;
    }
    
}