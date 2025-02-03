package com.example.demologaop.designpattern.builder.example.director;

import com.example.demologaop.designpattern.builder.example.buliders.Builder;
import com.example.demologaop.designpattern.builder.example.cars.CarType;
import com.example.demologaop.designpattern.builder.example.components.Engine;
import com.example.demologaop.designpattern.builder.example.components.GPSNavigator;
import com.example.demologaop.designpattern.builder.example.components.Transmission;
import com.example.demologaop.designpattern.builder.example.components.TripComputer;
/**
 * Director defines the order of building steps. It works with a builder object
 * through common Builder interface. Therefore, it may not know what product is
 * being built.
 */
public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0.0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2,0.0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5,0.0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}
