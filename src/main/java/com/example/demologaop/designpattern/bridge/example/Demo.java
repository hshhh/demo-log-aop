package com.example.demologaop.designpattern.bridge.example;

import com.example.demologaop.designpattern.bridge.example.devices.Device;
import com.example.demologaop.designpattern.bridge.example.devices.Radio;
import com.example.demologaop.designpattern.bridge.example.devices.Tv;
import com.example.demologaop.designpattern.bridge.example.remotes.AdvancedRemote;
import com.example.demologaop.designpattern.bridge.example.remotes.BasicRemote;

public class Demo {

    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");

        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
