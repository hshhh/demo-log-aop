package com.example.demologaop.designpattern.bridge.example.remotes;

import com.example.demologaop.designpattern.bridge.example.devices.Device;

public class AdvancedRemote extends BasicRemote{

    public AdvancedRemote(Device device) {
        super(device);
    }
    // 静音
    public void mute() {
        System.out.println("Remote: mute");
        super.device.setVolume(0);
        // device.setVolume(0);
    }
}
