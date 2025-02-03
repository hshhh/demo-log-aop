package com.example.demologaop.designpattern.abstract_factory.example.factories;

import com.example.demologaop.designpattern.abstract_factory.example.buttons.Button;
import com.example.demologaop.designpattern.abstract_factory.example.checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
