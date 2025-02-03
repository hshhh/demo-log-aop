package com.example.demologaop.designpattern.abstract_factory.example.buttons;

/**
 * All products families have the same varieties (MacOS/Windows).
 * This is another variant of Button.
 *
 * @author huangshihao
 */
public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton");
    }
}
