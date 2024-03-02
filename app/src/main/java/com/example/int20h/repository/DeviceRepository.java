package com.example.int20h.repository;

import com.example.int20h.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository {
    Optional<Device> getById(Long id);

    List<Device> getAll();

    boolean addAll(List<Device> devices);

    boolean add(Device device);

    Optional<Device> getDeviceByTypeBrandModel(String type, String brand, String model);
}
