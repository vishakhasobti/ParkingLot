package com.parking.service;

import com.parking.models.Vehicle;
import com.parking.models.VehicleType;
import com.parking.repositories.VehicleRepository;

public class VehicleService {

    //get or register the vehicle , do via repository

    private VehicleRepository vehicleRepository;

    public VehicleService (VehicleRepository vehicleRepository){
        this.vehicleRepository=vehicleRepository;
    }

    public Vehicle getVehicle(String vehiclenumber){
        return vehicleRepository.getVehicleFromVehicleNumber(vehiclenumber);


    }

    public Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType){
        retun vehicleRepository.vehicleRepository.addVehicle(new Vehicle(vehicleType,vehicleNumber);
    }

}
