package com.cskaoyan.pojo;

import java.util.Date;

public class DeviceFaultVO {
    private String deviceFaultId;

    private String deviceId;

    private String deviceFaultCause;

    private String deviceFaultDetail;

    private Date deviceFaultDate;

    private String deviceFaultMaintenance;

    public String deviceName;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId == null ? null : deviceFaultId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceFaultCause() {
        return deviceFaultCause;
    }

    public void setDeviceFaultCause(String deviceFaultCause) {
        this.deviceFaultCause = deviceFaultCause == null ? null : deviceFaultCause.trim();
    }

    public String getDeviceFaultDetail() {
        return deviceFaultDetail;
    }

    public void setDeviceFaultDetail(String deviceFaultDetail) {
        this.deviceFaultDetail = deviceFaultDetail == null ? null : deviceFaultDetail.trim();
    }

    public Date getDeviceFaultDate() {
        return deviceFaultDate;
    }

    public void setDeviceFaultDate(Date deviceFaultDate) {
        this.deviceFaultDate = deviceFaultDate;
    }

    public String getDeviceFaultMaintenance() {
        return deviceFaultMaintenance;
    }

    public void setDeviceFaultMaintenance(String deviceFaultMaintenance) {
        this.deviceFaultMaintenance = deviceFaultMaintenance == null ? null : deviceFaultMaintenance.trim();
    }

    @Override
    public String toString() {
        return "DeviceFaultVO{" +
                "deviceFaultId='" + deviceFaultId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceFaultCause='" + deviceFaultCause + '\'' +
                ", deviceFaultDetail='" + deviceFaultDetail + '\'' +
                ", deviceFaultDate=" + deviceFaultDate +
                ", deviceFaultMaintenance='" + deviceFaultMaintenance + '\'' +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}