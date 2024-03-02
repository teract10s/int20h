package com.example.int20h.repository;

import com.example.int20h.model.Device;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DeviceRepositoryApiImpl implements DeviceRepository {
    private final String baseUrl = "http://localhost:8080/api/devices";

    @Override
    public Optional<Device> getById(Long id) {
        String strUrl = baseUrl + "/" + id;
        Optional<Device> device = Optional.empty();
        try {
            URL url = new URL(strUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();

            ObjectMapper objectMapper = new ObjectMapper();
            device = Optional.of(objectMapper.readValue(response.toString(), Device.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return device;
    }

    @Override
    public List<Device> getAll() {
        List<Device> devices = null;
        try {
            URL url = new URL(baseUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();

            ObjectMapper objectMapper = new ObjectMapper();
            devices = Arrays.asList(objectMapper.readValue(response.toString(), Device[].class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devices;
    }

    @Override
    public boolean addAll(List<Device> devices) {
        try {
            URL url = new URL(baseUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonRequest = objectMapper.writeValueAsString(devices);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonRequest.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(Device device) {
        List<Device> devices = new ArrayList<>();
        devices.add(device);
        return addAll(devices);
    }

    @Override
    public Optional<Device> getDeviceByTypeBrandModel(String type, String brand, String model) {
        return Optional.empty();
    }
}
