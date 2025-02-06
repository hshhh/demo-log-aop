package com.example.demologaop.designpattern.adapter.example.round;
// 圆孔
public class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    // 圆孔 和 圆钉兼容
    public boolean fits(RoundPeg peg) {
        boolean result = false;
        result = this.getRadius() >= peg.getRadius();
        return result;
    }
}
