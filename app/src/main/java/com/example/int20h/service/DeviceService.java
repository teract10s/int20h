package com.example.int20h.service;

import android.content.Context;
import android.content.res.Resources;

import com.example.int20h.R;
import com.example.int20h.model.Device;
import com.example.int20h.parser.ReadingCSVFile;
import com.example.int20h.repository.DeviceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeviceService {
    private DeviceRepository deviceRepository;
    private Context context;

    public DeviceService(Context context, DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
        this.context = context;
        setUpRepo();
    }

    private void setUpRepo() {
        ReadingCSVFile parser = new ReadingCSVFile(context, R.raw.babymonitors);
        List<Device> devices = parser.getParsedList();
        deviceRepository.addAll(devices);
    }

    public Optional<Device> getDeviceByTypeBrandModel(String type, String brand, String model) {
        return deviceRepository.getDeviceByTypeBrandModel(type, brand, model);
    }

    public List<String> getTypes() {
        return deviceRepository.getTypes();
    }

    public List<String> getBrands() {
        return deviceRepository.getBrands();
    }

    public List<String> getBrandsByType(String type) {
        return deviceRepository.getBrandsByType(type);
    }

    public List<String> getModelsByBrand(String brand) {
        return deviceRepository.getModelsByBrand(brand);
    }

    public List<String> getModels() {
        return deviceRepository.getModels();
    }

    public boolean addAll(List<Device> devices) {
        return deviceRepository.addAll(devices);
    }

    public Optional<Device> getByModel(String model) {
        return deviceRepository.getByModel(model);
    }
}
