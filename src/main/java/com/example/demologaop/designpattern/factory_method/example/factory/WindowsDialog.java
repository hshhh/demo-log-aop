package com.example.demologaop.designpattern.factory_method.example.factory;

import com.example.demologaop.designpattern.factory_method.example.buttons.Button;
import com.example.demologaop.designpattern.factory_method.example.buttons.WindowsButton;

/**
 * @author huangshihao
 */
public class WindowsDialog extends Dialog{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
