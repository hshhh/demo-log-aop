package com.example.demologaop.designpattern.builder.example.cars;

import com.example.demologaop.designpattern.builder.example.components.Engine;
import com.example.demologaop.designpattern.builder.example.components.GPSNavigator;
import com.example.demologaop.designpattern.builder.example.components.Transmission;
import com.example.demologaop.designpattern.builder.example.components.TripComputer;

/**
 * 手册
 */
public class Manual {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    
    public Manual(CarType carType, int seats,
                  Engine engine, Transmission transmission,
                  TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
    }
    
    public String print() {
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append("Type of car: ").append(carType).append("\n");
        infoBuilder.append("Count of seats:").append(seats).append("\n");
        infoBuilder.append("Engine: volume - ").append(engine.getVolume())
                .append("; mileage - ").append(engine.getMileage()).append("\n");
        infoBuilder.append("Transmission: ").append(transmission).append("\n");
        if (this.tripComputer != null) {
            infoBuilder.append("Trip Computer: Functional \n");
        } else {
            infoBuilder.append("Trip Computer: N/A \n");
        }
        if (this.gpsNavigator != null) {
            infoBuilder.append("GPS Navigator: Functional \n");
        } else {
            infoBuilder.append("GPS Navigator: N/A \n");
        }
        return infoBuilder.toString();
    }
}
