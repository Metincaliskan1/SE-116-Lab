package com.space.exceptions;

public class InsufficientFuelException extends Exception{
    public InsufficientFuelException(){
        super("Not enough fuel for the mission task.");
    }


}
