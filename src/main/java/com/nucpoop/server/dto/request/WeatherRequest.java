package com.nucpoop.server.dto.request;

public class WeatherRequest {
    private String ServiceKey;
    private int pageNo;
    private int numOfRows;
    private String dataType;
    private String base_date;
    private String base_time;
    private int nx;
    private int ny;

    public WeatherRequest(int pageNo, int numOfRows, String dataType, String base_date,
        String base_time, int nx, int ny) {
        this.ServiceKey = "In700GpDhOczBBTNPW9EKqfV2XwqE5ff7638azwe2D9uetiEFgIRLsnK%2FIwzUVJc0xorUJOma6aR4bKJYRu7uQ%3D%3D";
        this.pageNo = pageNo;
        this.numOfRows = numOfRows;
        this.dataType = dataType;
        this.base_date = base_date;
        this.base_time = base_time;
        this.nx = nx;
        this.ny = ny;
    }

    public String getServiceKey(){
        return ServiceKey;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public String getDataType() {
        return dataType;
    }

    public String getBase_date() {
        return base_date;
    }

    public String getBase_time() {
        return base_time;
    }

    public int getNx() {
        return nx;
    }

    public int getNy() {
        return ny;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setBase_date(String base_date) {
        this.base_date = base_date;
    }

    public void setBase_time(String base_time) {
        this.base_time = base_time;
    }

    public void setNx(int nx) {
        this.nx = nx;
    }

    public void setNy(int ny) {
        this.ny = ny;
    }
}
