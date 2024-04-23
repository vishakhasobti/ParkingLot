package com.parking.controllers;

import com.parking.Excpetions.NoParkingSpotFoundException;
import com.parking.dto.GenerateTicketRequestDto;
import com.parking.dto.GenerateTicketResponse;
import com.parking.dto.ResponseStatus;
import com.parking.models.Gate;
import com.parking.models.Ticket;
import com.parking.models.Vehicle;
import com.parking.service.TicketService;

import java.util.Date;

public class TicketController {

    // Need to generate ticket

    /**
     *
     // 1. Get Vehicle from DB
     //2. if not part od DB , Create - add a vehicle

     //    2 ways:
     1)Have a repo to insert the date Repo.insertVehicle()
     2) have a service to insert the data Service.vehicle() == Better approach
     *
     *
     *   // Ticket Service - Generate Ticket
     *     // VehicleService - Get Vehicle By Number
     *     // VehicleService - Create Vehicle
     *     // assign Spot
     *     // createTicketAndStoreInDB
     * */
    // 2. Generate Ticket




    private TicketService ticketService;


    //to create a ticket controller, need ticket service
    public TicketController(TicketService ticketService) {
        this.ticketService=ticketService;

    }

    public GenerateTicketResponse generateTicket(GenerateTicketRequestDto generateRequestDto) {

        //businesslogic
        //Ticket Service , also we will have different service for different entity
        //service shd know about the data only its interested in

        GenerateTicketResponse responseDto = new GenerateTicketResponse();
        Ticket     ticket = null;
        try {
            ticket = ticketService.generateTicket(generateRequestDto.getVehicleNumber(),generateRequestDto.getGateId(),generateRequestDto.getVehicleType());
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        } catch (NoParkingSpotFoundException e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setResponseMessage(e.getMessage());
        }


        GenerateTicketResponse generateTicketResponse = new GenerateTicketResponse();
        generateTicketResponse.setTicket(ticket);
        //Before we generate the ticket check vehicle avaialbel or not in DB

        return generateTicketResponse;
    }

}
