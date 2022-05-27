package com.example.springbootexersize.configuration;


import com.example.springbootexersize.service.CarVehicleService;
import com.example.springbootexersize.service.PlaneVehicleService;
import com.example.springbootexersize.service.VehicleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfiguration {

    @Bean
    //@Qualifier("carVehicleServiceConfiguration")
    @ConditionalOnProperty(value = "vehicle.service.mode", havingValue = "car",matchIfMissing = false)
    public VehicleService carVehicleServiceConfiguration(){
        return new CarVehicleService();
    }

    @Bean
    //@Qualifier("planeVehicleServiceConfiguration")
    //  @Primary
    @ConditionalOnProperty(value = "vehicle.service.mode", havingValue = "plane",matchIfMissing = true)
    public VehicleService planeVehicleServiceConfiguration(){
        return new PlaneVehicleService();
    }
}
