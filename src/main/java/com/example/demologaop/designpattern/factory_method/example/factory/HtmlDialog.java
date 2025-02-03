package com.example.demologaop.designpattern.factory_method.example.factory;

import com.example.demologaop.designpattern.factory_method.example.buttons.Button;
import com.example.demologaop.designpattern.factory_method.example.buttons.HtmlButton;

public class HtmlDialog extends Dialog{
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
