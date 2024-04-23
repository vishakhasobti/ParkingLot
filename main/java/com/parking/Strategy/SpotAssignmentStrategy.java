package com.parking.Strategy;

import com.parking.models.Gate;
import com.parking.models.ParkingSpot;
import com.parking.models.VehicleType;

import java.util.List;

public interface SpotAssignmentStrategy {

    //assignn the spot

        ParkingSpot assignSpot(VehicleType vehicleType, Gate gate, List<ParkingSpot> parkingSpotList);

}
