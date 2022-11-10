package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Juego {

    String juegoID;
    String description;
    int  numNiveles;

    //static int lastId;

    //public Juego() {
      //  this.id = RandomUtils.getId();
    //}

    public Juego(String juegoID, String description, int numNiveles) {
        this.juegoID = juegoID;
        this.description = description;
        this.numNiveles = numNiveles;
    }

    public String getId() {

        return this.juegoID;
    }

    public void setId(String JuegoID) {

        this.juegoID=JuegoID;
    }


    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getNumNiveles() {

        return numNiveles ;
    }

    public void setNumNiveles(int numNiveles) {

        this.numNiveles = numNiveles;
    }

    @Override
    public String toString() {
        return "Juego [id="+juegoID+", description=" + description + ", numNiveles=" + numNiveles +"]";
    }

}