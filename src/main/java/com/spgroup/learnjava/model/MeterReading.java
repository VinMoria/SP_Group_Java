package com.spgroup.learnjava.model;

import java.util.Date;

public class MeterReading {
    private String meterId;
    private double reading;
    private Date timestamp;

    // Getters and Setters
    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public double getReading() {
        return reading;
    }

    public void setReading(double reading) {
        this.reading = reading;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
}