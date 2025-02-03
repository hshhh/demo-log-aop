package com.example.demologaop.designpattern.factory_method.example.factory;

import com.example.demologaop.designpattern.factory_method.example.buttons.Button;

/**
 * @author huangshihao
 */
public abstract class Dialog {
    public void renderWindow() {
        Button button = createButton();
        button.render();
    }
    public abstract Button createButton();
}
