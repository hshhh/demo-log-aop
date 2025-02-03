package com.example.demologaop.designpattern.builder.example.buliders;

import com.example.demologaop.designpattern.builder.example.cars.Car;
import com.example.demologaop.designpattern.builder.example.cars.CarType;
import com.example.demologaop.designpattern.builder.example.components.Engine;
import com.example.demologaop.designpattern.builder.example.components.GPSNavigator;
import com.example.demologaop.designpattern.builder.example.components.Transmission;
import com.example.demologaop.designpattern.builder.example.components.TripComputer;
/**
 * Concrete builders implement steps defined in the common interface.
 */
public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType carType) {
        this.type = carType;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
