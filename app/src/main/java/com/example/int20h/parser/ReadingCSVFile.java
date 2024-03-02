package com.example.int20h.parser;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import com.example.int20h.model.Device;
import com.opencsv.CSVReader;

public class ReadingCSVFile {
	
	private final String filePath;

	public ReadingCSVFile(String filePath) {
		this.filePath = filePath;
	}

	public List<Device> getParsedList() {
		List<Device> deviceList = new LinkedList<>();
		try {
			String[] fileLines;
			CSVReader csvReader = new CSVReader(new FileReader(filePath));
			csvReader.skip(1);
			while ((fileLines = csvReader.readNext()) != null) {
				deviceList.add(deviceInitialization(fileLines));
			}
		} catch (Exception e) {
			throw new RuntimeException("Can't parse file: " + filePath, e);
		}
		return deviceList;
	}

	private Device deviceInitialization(String[] fileLines){
		Device deviceEntity = new Device();
		deviceEntity.setId(Long.valueOf(fileLines[0]));
		deviceEntity.setType(fileLines[1]);
		deviceEntity.setBrand(fileLines[2]);
		deviceEntity.setModel(fileLines[3]);
		deviceEntity.setVideoSharing(parseToBoolean(fileLines[4]));
		deviceEntity.setWifi(parseToBoolean(fileLines[5]));
		deviceEntity.setFrequency24(parseToBoolean(fileLines[6]));
		deviceEntity.setFrequency5(parseToBoolean(fileLines[7]));
		deviceEntity.setSecurityProtocol(fileLines[8]);
		deviceEntity.setPrivacyShutter(parseToBoolean(fileLines[9]));
		deviceEntity.setEncryption(fileLines[10]);
		deviceEntity.setSecure(parseToBoolean(fileLines[11]));
		deviceEntity.setUrl(fileLines[12]);
		deviceEntity.setComments(fileLines[13]);
		return deviceEntity;
	}

	private boolean parseToBoolean(String message){
		return (message.compareTo("TRUE") == 0) | (message.compareTo("YES") == 0);
	}
}
