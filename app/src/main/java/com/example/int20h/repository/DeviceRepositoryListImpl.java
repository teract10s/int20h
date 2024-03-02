package com.example.int20h.repository;

import com.example.int20h.model.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
}
