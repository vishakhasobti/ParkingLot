package com.parking.service;

import com.parking.Strategy.SpotAssignmentStrategy;
import com.parking.models.Gate;
import com.parking.models.ParkingSpot;
import com.parking.models.Vehicle;
import com.parking.repositories.ParkingLotRepository;

import java.util.List;

public class ParkingLotService {

        SpotAssignmentStrategy spotAssignmentStrategy ;
    ParkingLotRepository parkingLotRepository;

        public ParkingLotService(SpotAssignmentStrategy spotAssignmentStrategy){
            this.spotAssignmentStrategy=spotAssignmentStrategy;

        }
    public ParkingSpot getparkingSpot(Vehicle vehicle, Gate gate){
            //who will give me parking spots by all the parking lots? repository

        List<ParkingSpot> parkingSpotList = parkingLotRepository.getAllParkingSpots();

         return spotAssignmentStrategy.assignSpot(vehicle.getVehicleType(), gate, parkingSpotList);
    }
}
