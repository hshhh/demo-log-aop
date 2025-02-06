package com.example.demologaop.designpattern.prototype.example.shapes;

/**
 * 具体原型。克隆方法会创建一个新对象并将其传递给构造函数。
 * 直到构造函数运行完成前，它都拥有指向新克隆对象的引用。因此，
 * 任何人都无法访问未完全生成的克隆对象。这可以保持克隆结果的一致性。
 */
public class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle() {}

    public Rectangle(Rectangle target) {
        // 需要调用父类构造函数来复制父类中定义的私有成员变量
        super(target);
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) {
            return false;
        }
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }
}
