package com.example.int20h.model;

public class Device {
    private Long id;

    private String type;

    private String brand;

    private String model;

    private boolean videoSharing;

    private boolean wifi;

    private boolean frequency24;

    private boolean frequency5;

    private String securityProtocol;

    private boolean privacyShutter;

    private String encryption;

    private boolean isSecure;

    private String url;

    private String comments;

    public Device() {
    }

    public Device(Long id, String type, String brand, String model,
                  boolean videoSharing, boolean wifi, boolean frequency24,
                  boolean frequency5, String securityProtocol, boolean privacyShutter,
                  String encryption, boolean isSecure, String url, String comments) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.videoSharing = videoSharing;
        this.wifi = wifi;
        this.frequency24 = frequency24;
        this.frequency5 = frequency5;
        this.securityProtocol = securityProtocol;
        this.privacyShutter = privacyShutter;
        this.encryption = encryption;
        this.isSecure = isSecure;
        this.url = url;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isVideoSharing() {
        return videoSharing;
    }

    public void setVideoSharing(boolean videoSharing) {
        this.videoSharing = videoSharing;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isFrequency24() {
        return frequency24;
    }

    public void setFrequency24(boolean frequency24) {
        this.frequency24 = frequency24;
    }

    public boolean isFrequency5() {
        return frequency5;
    }

    public void setFrequency5(boolean frequency5) {
        this.frequency5 = frequency5;
    }

    public String getSecurityProtocol() {
        return securityProtocol;
    }

    public void setSecurityProtocol(String securityProtocol) {
        this.securityProtocol = securityProtocol;
    }

    public boolean isPrivacyShutter() {
        return privacyShutter;
    }

    public void setPrivacyShutter(boolean privacyShutter) {
        this.privacyShutter = privacyShutter;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    public boolean isSecure() {
        return isSecure;
    }

    public void setSecure(boolean secure) {
        isSecure = secure;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
