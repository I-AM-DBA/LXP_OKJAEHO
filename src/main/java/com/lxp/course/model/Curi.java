package com.lxp.curi.model;

public class Curi {
    private Long curiNo;
    private String curriName;
    private String depth1Name;
    private String depth2Name;
    private boolean success;
    private String depth2Time;

    public Curi() {
    }

    public Curi(Long curiNo, String curriName, String depth1Name, String depth2Name,
            boolean success, String depth2Time) {
        this.curiNo = curiNo;
        this.curriName = curriName;
        this.depth1Name = depth1Name;
        this.depth2Name = depth2Name;
        this.success = success;
        this.depth2Time = depth2Time;
    }

    public Long getCuriNo() {
        return curiNo;
    }

    public void setCuriNo(Long curiNo) {
        this.curiNo = curiNo;
    }

    public String getCurriName() {
        return curriName;
    }

    public void setCurriName(String curriName) {
        this.curriName = curriName;
    }

    public String getDepth1Name() {
        return depth1Name;
    }

    public void setDepth1Name(String depth1Name) {
        this.depth1Name = depth1Name;
    }

    public String getDepth2Name() {
        return depth2Name;
    }

    public void setDepth2Name(String depth2Name) {
        this.depth2Name = depth2Name;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDepth2Time() {
        return depth2Time;
    }

    public void setDepth2Time(String depth2Time) {
        this.depth2Time = depth2Time;
    }

    @Override
    public String toString() {
        return "Curi{" + "curiNo=" + curiNo + ", curriName='" + curriName + '\'' + ", depth1Name='"
                + depth1Name + '\'' + ", depth2Name='" + depth2Name + '\'' + ", success=" + success
                + ", depth2Time='" + depth2Time + '\'' + '}';
    }
}
