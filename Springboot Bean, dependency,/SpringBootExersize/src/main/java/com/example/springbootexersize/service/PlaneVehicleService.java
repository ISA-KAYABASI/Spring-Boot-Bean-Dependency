package com.example.springbootexersize.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PlaneVehicleService implements VehicleService{

    private Logger log = LoggerFactory.getLogger(PlaneVehicleService.class);

    @Override
    public void startEngine() {
        log.info("Plane engien started...");
    }

    @Override
    public void move() {
        log.info("Plane start to flying...");
    }

    @Override
    public void stopEngine() {
        log.info("Plane start to landing...");
    }
}
