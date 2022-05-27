package com.example.springbootexersize;

import com.example.springbootexersize.service.CarVehicleService;
import com.example.springbootexersize.service.VehicleService;
import com.example.springbootexersize.service.VehicleTestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootExersizeApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootExersizeApplication.class, args);
        VehicleService vehicleService = context.getBean(VehicleService.class); //we can add 'Car' start of the VehicleService and it will make first run the car
        vehicleService.startEngine();
        vehicleService.move();
        vehicleService.stopEngine();
        VehicleTestService vehicleTestService = context.getBean(VehicleTestService.class);
        vehicleTestService.testVehicle();

    }

}
