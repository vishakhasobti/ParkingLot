package com.parking.repositories;

import com.parking.models.Vehicle;
import com.parking.models.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {

    // create db connection & store

    // if no DB setup ,  In memory -- MAP of strings
    Map<String, Vehicle> vehiclestore;
//inmemory DB
     public VehicleRepository() {
         vehiclestore = new HashMap<String, Vehicle>();

    }

    public Vehicle getVehicleFromVehicleNumber(String vehicleNumber) {
        return null;
    }

    public  Vehicle addVehicle(Vehicle vehicle){
        vehiclestore.put(Vehicle.getNumber(),vehicle);
        return vehicle;
    }
}
