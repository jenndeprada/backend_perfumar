package com.perfumar.perfumar.handler;

public class HandleExceptionInRest extends Exception {
    //agarra las exceptions que se generan en las rutas restfull y
    //se las pasa con super a Spring

    private String message;

    //Esto era un constructor?
    public HandleExceptionInRest(String message) {
        super(message);
    }


}
