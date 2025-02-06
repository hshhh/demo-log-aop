package com.example.demologaop.designpattern.adapter.example.adapters;

import com.example.demologaop.designpattern.adapter.example.round.RoundPeg;
import com.example.demologaop.designpattern.adapter.example.square.SquarePeg;

/**
 * 适配器类让你能够将方钉放入圆孔中，它对 RoundPeg类进行扩展，
 * 以接收适配器对象作为圆钉
 */
public class SquarePegAdapter extends RoundPeg {

    // 持有方钉（SquarePeg 类）实例
    private SquarePeg squarePeg;

    // 构造函数 传入一个方钉（SquarePeg 类）实例
    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    // 重写获取半径方法，这样适配器会假扮一个圆钉，
    // 其半径刚好能与适配器实际封装的方钉搭配起来
    @Override
    public double getRadius() {
        double result;
        //  计算一个可以拟合此方钉的最小圆半径。
        result = Math.sqrt(Math.pow(squarePeg.getWidth(), 2) * 2.0)/2.0;
        return result;
    }
}
