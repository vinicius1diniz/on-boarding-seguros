package com.example.hexagonal.adapters.in.controller.response;

public class AddressResponse {
    private String sreet;
    private String city;
    private String state;

    public String getSreet() {
        return sreet;
    }

    public void setSreet(String sreet) {
        this.sreet = sreet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
