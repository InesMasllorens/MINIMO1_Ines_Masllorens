package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Partida {

    String userID;
    String juegoID;
    List<LJ> ljs;

    public Partida(String userID, String juegoID){

        this.userID = userID;
        this.juegoID = juegoID;
        this.ljs = new LinkedList<>();

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getJuegoID() {
        return juegoID;
    }

    public void setJuegoID(String juegoID) {
        this.juegoID = juegoID;
    }

    public List<LJ> getLjs() {
        return ljs;
    }

    public void setLjs(List<LJ> ljs) {
        this.ljs = ljs;
    }


}


