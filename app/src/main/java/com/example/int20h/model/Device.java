package com.example.int20h.model;

public class Device {
    private Long id;
    private String type;
    private String brand;
    private String model;
    private boolean videoSharing;
    private boolean wifi;
    private boolean frequency245;
    private String securityProtocol;
    private boolean privacyShutter;
    private String encryption;
    private boolean isSecure;
    private String url;
    private String comments;

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

    public boolean isFrequency245() {
        return frequency245;
    }

    public void setFrequency245(boolean frequency245) {
        this.frequency245 = frequency245;
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
