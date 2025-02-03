package com.example.demologaop.designpattern.abstract_factory.example.factories;

import com.example.demologaop.designpattern.abstract_factory.example.buttons.Button;
import com.example.demologaop.designpattern.abstract_factory.example.buttons.MacOSButton;
import com.example.demologaop.designpattern.abstract_factory.example.checkboxes.Checkbox;
import com.example.demologaop.designpattern.abstract_factory.example.checkboxes.MacOsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating products of a single variety
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOsCheckbox();
    }
}
