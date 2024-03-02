package com.example.int20h.service;

import com.example.int20h.model.Device;
import com.example.int20h.repository.DeviceRepository;

import java.util.Optional;

public class DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Optional<Device> getDeviceByTypeBrandModel(String type, String brand, String model) {
        return deviceRepository.getDeviceByTypeBrandModel(type, brand, model);
    }
}
