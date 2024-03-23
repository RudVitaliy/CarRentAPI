package com.vrdnk.CarRentAPI.exceptions;

public class EntityNotCreatedException extends RuntimeException{
    public EntityNotCreatedException(String msg){
        super(msg);
    }
}
