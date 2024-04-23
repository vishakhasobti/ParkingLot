package com.parking.Strategy;

import com.parking.models.Gate;
import com.parking.models.ParkingSpot;
import com.parking.models.ParkingSpotStatus;
import com.parking.models.VehicleType;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {


        public ParkingSpot assignSpot(VehicleType vehicleType,
                                  Gate gate, List<ParkingSpot> parkingSpots){

            // we need to get all the parking spots
            //who knows?Parkinglot  List<ParkingSpot> parkingSpots

                for(ParkingSpot parkingSpot: parkingSpots){
                    if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
                            parkingSpot.getSupportedVehicleTypes().contains(vehicleType)) {
                        return parkingSpot;
                    }
                }

            return null;
        }

}
