package com.parking.models;

public class Vehicle extends BaseModel{
    private VehicleType vehicleType;
    private  String number;

    public Vehicle(VehicleType vehicleType, String number){
        this.vehicleType = vehicleType;
        this.number = number;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public static String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
