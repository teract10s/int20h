package com.example.int20h.service;

import com.example.int20h.model.Device;
import com.example.int20h.repository.DeviceRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Optional<Device> getDeviceByTypeBrandModel(String type, String brand, String model) {
        return deviceRepository.getDeviceByTypeBrandModel(type, brand, model);
    }

    public List<String> getTypes() {
        return deviceRepository.getTypes();
    }

    public List<String> getBrandsByType(String type) {
        return deviceRepository.getBrandsByType(type);
    }

    public List<String> getModelsByBrand(String brand) {
        return deviceRepository.getModelsByBrand(brand);
    }

    public boolean addAll(List<Device> devices) {
        return deviceRepository.addAll(devices);
    }
}
