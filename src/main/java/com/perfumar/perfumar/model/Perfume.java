package com.perfumar.perfumar.model;

public class Perfume {

    private final int id;
    private final String name;
    private final String brand;

    //contructor
    public Perfume(int id, String name, String brand){
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getBrand(){
        return brand;
    }





}
