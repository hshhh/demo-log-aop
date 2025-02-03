package com.example.demologaop.designpattern.builder.example.buliders;

import com.example.demologaop.designpattern.builder.example.cars.CarType;
import com.example.demologaop.designpattern.builder.example.components.Engine;
import com.example.demologaop.designpattern.builder.example.components.GPSNavigator;
import com.example.demologaop.designpattern.builder.example.components.Transmission;
import com.example.demologaop.designpattern.builder.example.components.TripComputer;
/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCarType(CarType carType);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
