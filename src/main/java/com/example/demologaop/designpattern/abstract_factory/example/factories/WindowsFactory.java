package com.example.demologaop.designpattern.abstract_factory.example.factories;

import com.example.demologaop.designpattern.abstract_factory.example.buttons.Button;
import com.example.demologaop.designpattern.abstract_factory.example.buttons.WindowsButton;
import com.example.demologaop.designpattern.abstract_factory.example.checkboxes.Checkbox;
import com.example.demologaop.designpattern.abstract_factory.example.checkboxes.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible fot creating products of a single variety.
 */
public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
