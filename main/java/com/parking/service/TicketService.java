package com.parking.service;

import com.parking.Excpetions.NoParkingSpotFoundException;
import com.parking.models.*;
import com.parking.repositories.TicketRepository;

import java.util.Date;

public class TicketService {
//handles all the services
public  VehicleService vehicleService;

public  GateService gateService;
    private ParkingLotService parkingLotService;
private TicketRepository ticketRepository;


//tocreate a ticket service , need all the abpve service

    public TicketService(VehicleService vehicleService,
                         GateService gateService,
                         ParkingLotService parkingLotService,
                         TicketRepository ticketRepository) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.parkingLotService = parkingLotService;
        this.ticketRepository = ticketRepository;
    }
    public Ticket generateTicket(String vehicleNumber, Long gateId, VehicleType vehicleType) throws NoParkingSpotFoundException {

        // Check if the vehicle present in the DB, if not then create and store in DB
        // 1. VehicleService - getVehicleByNumber - recommened Approach
        // 2. VehicleRepo - fetchByNumber

        // get or create the vehicle
        // create ticket
        //repository do return the object
    // have vehicle service for every call
        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
             if(vehicle == null){
                    //register
                vehicle=vehicleService.registerVehicle(vehicleNumber,vehicleType);

             }

             //gate details
            Gate gate=gateService.getGateById(gateId);

             //
            //assign parking lot , who? parkinglotservice
        // Spot Assigment strategy to be part parking lot service
        ParkingSpot parkingSpot = parkingLotService.getparkingSpot(vehicle, gate);

        if(parkingSpot == null){
            throw new NoParkingSpotFoundException("No Parking Spot Available");
        }
        //assihn the parking spot
//        ParkingSpot parkingSpot = parkingLotService.assignParkingSpot(parkingSpot);
        //update the status of parkingspot


        //ticket generation

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setEntrytime(new Date());
        ticket.setParkingSpot(parkingSpot);

        /// saving the ticket to repo
        ticketRepository.saveTicket(ticket);
        return ticket;

    }
}
