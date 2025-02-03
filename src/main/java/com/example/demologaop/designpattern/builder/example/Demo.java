package com.example.demologaop.designpattern.builder.example;

import com.example.demologaop.designpattern.builder.example.buliders.CarBuilder;
import com.example.demologaop.designpattern.builder.example.buliders.CarManualBuilder;
import com.example.demologaop.designpattern.builder.example.cars.Car;
import com.example.demologaop.designpattern.builder.example.cars.Manual;
import com.example.demologaop.designpattern.builder.example.director.Director;

public class Demo {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);

        Car car = carBuilder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual manual = manualBuilder.getResult();

        System.out.println("\nCar Manual built:\n" + manual.print());
    }
}
