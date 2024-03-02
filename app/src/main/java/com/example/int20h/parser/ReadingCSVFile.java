package com.example.int20h.parser;

import android.content.Context;
import android.content.res.Resources;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import com.example.int20h.model.Device;
import com.opencsv.CSVReader;

public class ReadingCSVFile {

	private final InputStream inputStream;

	public ReadingCSVFile(Context context, int resourceId) {
		Resources resources = context.getResources();
		inputStream = resources.openRawResource(resourceId);
	}

	public List<Device> getParsedList() {
		List<Device> deviceList = new LinkedList<>();
		try {
			String[] fileLines;
			CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
			csvReader.skip(1);
			while ((fileLines = csvReader.readNext()) != null) {
				deviceList.add(deviceInitialization(fileLines));
			}
		} catch (Exception e) {
			throw new RuntimeException("Can't parse file", e);
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
