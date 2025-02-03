package com.example.demologaop.designpattern.abstract_factory.example;

import com.example.demologaop.designpattern.abstract_factory.example.app.Application;
import com.example.demologaop.designpattern.abstract_factory.example.factories.GUIFactory;
import com.example.demologaop.designpattern.abstract_factory.example.factories.MacOSFactory;
import com.example.demologaop.designpattern.abstract_factory.example.factories.WindowsFactory;

public class Demo {

    /**
     * Application picks the factory type and creates it in run time (usually at initialization stage),
     * depending on the configuration or environment variables.
     * @return Application
     */
    private static Application configureApplication() {
        Application application;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        application = new Application(factory);
        return application;
    }

    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }
}
