package com.parking.Excpetions;

public class NoParkingSpotFoundException extends Throwable {
    public NoParkingSpotFoundException(String message) {
        super(message);
    }
}
