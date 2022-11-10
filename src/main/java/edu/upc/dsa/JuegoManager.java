package edu.upc.dsa;

import edu.upc.dsa.models.Partida;

import java.util.List;

public interface JuegoManager {


    public Partida addPartida(String userID, String juegoID);
    public Partida addPartida(Partida t);
    public Partida getPartida(String userID, String juegoID);
    public List<Partida> findAll();

    int numUsers();

    int numJuegos();

    int numPartidas();

    void addUser(String userID, String name, String surname, int puntos);

    void addJuego(String juegoID, String description, int numNiveles);

    public void deletePartida(String userID, String juegoID);
    public Partida updateTrack(Partida t);

    public int size();

    Partida updatePartida(Partida p);

    int puntuacionActual(String userID);
}
