package com.example.int20h.util;

import com.example.int20h.model.Device;

public class CurrentDevice {
    private static Device device;

    public static Device getDevice() {
        return device;
    }

    public static void setDevice(Device device) {
        CurrentDevice.device = device;
    }
}
