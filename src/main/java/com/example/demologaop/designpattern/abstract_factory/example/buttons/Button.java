package com.example.demologaop.designpattern.abstract_factory.example.buttons;

/**
 * Abstract Factory assumes that you have several families of products,
 * structured into seperated class hierarchies (Button/Checkbox). All products of
 * the same family must have the common interface.
 * This is the common interface for buttons family.
 */
public interface Button {
    void paint();
}
