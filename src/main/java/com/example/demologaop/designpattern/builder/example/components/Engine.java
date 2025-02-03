package com.example.demologaop.designpattern.builder.example.components;

public class Engine {
    // 容量
    private final double volume;
    // 里程
    private double mileage;
    private boolean started;

    public Engine(double volume, double mileage) {
        this.mileage = mileage;
        this.volume = volume;
    }

    public void on() {
        this.started = true;
    }
    public void off() {
        this.started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void go(double mileage) {
        if (started) {
            this.mileage += mileage;
        } else {
            System.err.println("Cannot go(), you must start engine first!");
        }
    }

    public double getVolume() {
        return this.volume;
    }

    public double getMileage() {
        return this.mileage;
    }
}
