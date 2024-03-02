package com.example.int20h.service;

import com.example.int20h.model.Device;
import com.example.int20h.parser.ReadingCSVFile;
import com.example.int20h.repository.DeviceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeviceService {
    private DeviceRepository deviceRepository;
    private static final String DEFAULT_DEVICES_FILE_PATH = "app/src/main/res/babymonitors.csv";


    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
        List<Device> devices = new ArrayList<>();
        devices.add(new Device(1L, "type1", "brand1", "model1", true, true, true, true, "Base64", true, "encrypt1", true, "url1", "comments"));
        devices.add(new Device(2L, "type2", "brand2", "model2", true, true, true, true, "Base64", true, "encrypt1", true, "url1", "comments"));
        devices.add(new Device(3L, "type1", "brand2", "model2", true, true, true, true, "Base64", true, "encrypt1", true, "url1", "comments"));
        devices.add(new Device(4L, "type2", "brand1", "model2", true, true, true, true, "Base64", true, "encrypt1", true, "url1", "comments"));
        deviceRepository.addAll(devices);
        // TODO: implement parsing
        //setUpRepo();
    }

    private void setUpRepo() {
        ReadingCSVFile parser = new ReadingCSVFile(DEFAULT_DEVICES_FILE_PATH);
        List<Device> devices = parser.getParsedList();
        deviceRepository.addAll(devices);
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
