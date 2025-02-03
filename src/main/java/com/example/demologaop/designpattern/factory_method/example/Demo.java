package com.example.demologaop.designpattern.factory_method.example;

import com.example.demologaop.designpattern.factory_method.example.factory.Dialog;
import com.example.demologaop.designpattern.factory_method.example.factory.HtmlDialog;
import com.example.demologaop.designpattern.factory_method.example.factory.WindowsDialog;

/**
 * @author huangshihao
 */
public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        if ("Windows 11".equals(System.getProperty("os.name"))) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
