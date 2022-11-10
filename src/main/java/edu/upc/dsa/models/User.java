package edu.upc.dsa.models;

import java.util.List;

public class User {
        String userID;
        String name;
        String surname;

        int puntos = 50;

        List<Partida> userPartidas;


    public User(String userID, String name, String surname, int puntos){
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.puntos = 50;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


}
