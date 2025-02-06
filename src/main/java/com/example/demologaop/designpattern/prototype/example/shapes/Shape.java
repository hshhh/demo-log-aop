package com.example.demologaop.designpattern.prototype.example.shapes;

import java.util.Objects;

/**
 * @author 26877
 */
// 基础原型
public abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape() {}

    // 原型构造函数，使用已有对象的数值初始化一个新对象
    public Shape(Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    // clone（克隆）操作会返回一个形状子类
    @Override
    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape)) {
            return false;
        }
        Shape shape2 = (Shape) object2;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, this.color);
    }
}
