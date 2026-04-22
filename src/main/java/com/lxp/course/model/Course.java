package com.lxp.curi.model;

public class Curriculum {
    // 1. curriculum 테이블 관련
    private Long curriNo;
    private String curriName;
    private boolean success;

    // 2. depth1 테이블 관련
    private Long depth1No;
    private String depth1Name;

    // 3. depth2 테이블 관련
    private Long depth2No;
    private String depth2Name;
    private Long depth2Time;

    public Curriculum(Long curriNo, String curriName, boolean success, Long depth1No,
            String depth1Name, Long depth2No, String depth2Name, Long depth2Time) {
        this.curriNo = curriNo;
        this.curriName = curriName;
        this.success = success;
        this.depth1No = depth1No;
        this.depth1Name = depth1Name;
        this.depth2No = depth2No;
        this.depth2Name = depth2Name;
        this.depth2Time = depth2Time;
    }

    public Long getCurriNo() {
        return curriNo;
    }

    public void setCurriNo(Long curriNo) {
        this.curriNo = curriNo;
    }

    public String getCurriName() {
        return curriName;
    }

    public void setCurriName(String curriName) {
        this.curriName = curriName;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getDepth1No() {
        return depth1No;
    }

    public void setDepth1No(Long depth1No) {
        this.depth1No = depth1No;
    }

    public String getDepth1Name() {
        return depth1Name;
    }

    public void setDepth1Name(String depth1Name) {
        this.depth1Name = depth1Name;
    }

    public Long getDepth2No() {
        return depth2No;
    }

    public void setDepth2No(Long depth2No) {
        this.depth2No = depth2No;
    }

    public String getDepth2Name() {
        return depth2Name;
    }

    public void setDepth2Name(String depth2Name) {
        this.depth2Name = depth2Name;
    }

    public Long getDepth2Time() {
        return depth2Time;
    }

    public void setDepth2Time(Long depth2Time) {
        this.depth2Time = depth2Time;
    }

    @Override
    public String toString() {
        return "Curriculum{" + "curriNo=" + curriNo + ", curriName='" + curriName + '\''
                + ", success=" + success + ", depth1No=" + depth1No + ", depth1Name='" + depth1Name
                + '\'' + ", depth2No=" + depth2No + ", depth2Name='" + depth2Name + '\''
                + ", depth2Time=" + depth2Time + '}';
    }
}

