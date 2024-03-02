package com.example.int20h.repository;

import com.example.int20h.model.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeviceRepositoryListImpl implements DeviceRepository {
    private List<Device> devices = new ArrayList<>();

    @Override
    public Optional<Device> getById(Long id) {
        return devices.stream()
                .filter(d -> Objects.equals(d.getId(), id))
                .findFirst();
    }

    @Override
    public List<Device> getAll() {
        return devices;
    }

    @Override
    public boolean addAll(List<Device> devices) {
        return this.devices.addAll(devices);
    }

    @Override
    public boolean add(Device device) {
        return devices.add(device);
    }

    @Override
    public Optional<Device> getDeviceByTypeBrandModel(String type, String brand, String model) {
        return devices.stream()
                .filter(d ->
                    d.getBrand().equals(brand) && d.getType().equals(type) && d.getModel().equals(model))
                .findFirst();
    }

    @Override
    public List<String> getTypes() {
        return devices.stream()
                .map(Device::getType)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBrandsByType(String type) {
        return devices.stream()
                .filter(d -> d.getType().equals(type))
                .map(Device::getBrand)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getModelsByBrand(String brand) {
        return devices.stream()
                .filter(d -> d.getBrand().equals(brand))
                .map(Device::getModel)
                .distinct()
                .collect(Collectors.toList());
    }
}
