package com.example.demologaop.designpattern.adapter.example.square;
// 方钉
public class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    // 获取方钉的宽度
    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2);
        return result;
    }
}
