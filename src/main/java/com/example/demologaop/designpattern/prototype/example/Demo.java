package com.example.demologaop.designpattern.prototype.example;

import com.example.demologaop.designpattern.prototype.example.shapes.Circle;
import com.example.demologaop.designpattern.prototype.example.shapes.Rectangle;
import com.example.demologaop.designpattern.prototype.example.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";

        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes 是不同的对象 (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(" " + " 而且它们是相同的 (yay!)");
                } else {
                    System.out.println(" " + " 但它们并不相同 (booo!)");
                }
            } else {
                System.out.println(i + ": Shape 对象是相同的 (booo!)");
            }
        }
    }
}
