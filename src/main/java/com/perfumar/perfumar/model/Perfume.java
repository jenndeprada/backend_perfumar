package com.perfumar.perfumar.model;
import java.util.UUID;

public class Perfume {

    private final UUID id;
    private final String name;

    //contructor
    public Perfume(UUID id, String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId(){
        return id;
    }
    public String getName(){
        return name;
    }



}
