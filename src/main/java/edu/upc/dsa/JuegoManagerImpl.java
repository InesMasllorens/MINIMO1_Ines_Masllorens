package edu.upc.dsa;

import edu.upc.dsa.models.Juego;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

public class JuegoManagerImpl implements JuegoManager {

        Map<String, User> users;
        List<Juego> juegos;
        List<Partida>partidas;

        private static JuegoManager instance;

        public JuegoManagerImpl(){
            users = new HashMap<>();
            juegos = new LinkedList<>();
            partidas = new LinkedList<>();
        }

        final static Logger logger = Logger.getLogger(String.valueOf(JuegoManagerImpl.class));

        public static JuegoManager getInstance() {
        if (instance==null) instance = new JuegoManagerImpl();
        return instance;
    }

        public int size() {
        int ret = this.juegos.size();
        logger.info("size " + ret);

        return ret;
    }

        public Partida addPartida(Partida t) {
        logger.info("new Partida " + t);

        this.partidas.add (t);
        logger.info("new Partida added");
        return t;
    }

    public Partida addPartida(String userID, String juegoID) {
        return this.addPartida(new Partida(userID, juegoID));
    }

    public Partida getPartida(String userID, String juegoID) {
        logger.info("getPartida("+userID+", "+juegoID+");

        for (Partida t: this.partidas) {
            if ((t.getUserID().equals(userID)) && (t.getJuegoID().equals(juegoID))) {
                logger.info("getPartida("+userID+", "+juegoID+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + userID);
        return null;
    }

    public List<Partida> findAll() {
        return this.partidas;
    }

    @Override
    public int numUsers(){
        return this.users.size();
    }

    @Override
    public int numJuegos(){
        return this.juegos.size();
    }

    @Override
    public int numPartidas(){
        return this.partidas.size();
    }

    @Override
    public void addUser(String userID, String name, String surname, int puntos)
    {
       User user =new User (userID, name, surname, puntos);
       users.put((userID,name,surname,puntos));
    }

    @Override
    public void addJuego(String juegoID, String description, int numNiveles) {
        Juego juego = new Juego(juegoID, description, numNiveles);
        juego.add(juego);
    }

    @Override
    public void deletePartida(String userID, String juegoID) {

        Partida t = this.getPartida(userID, juegoID);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.juegos.remove(t);

    }

    @Override
    public Partida updatePartida(Partida p) {
        Partida t = this.getPartida(p.getUserID(), p.getJuegoID());

        if (t != null) {
            logger.info(p + " rebut!!!! ");

            t.setJuegoID(p.getJuegoID());
            t.setUserID(p.getUserID());

            logger.info(t + " updated ");
        } else {
            logger.warn("not found " + p);
        }

        return t;
    }

    @Override
    public int puntuacionActual(String userID){
        int p = 50;
        User user = getUser(userID);
        if ( user != null){
            p = user.getPuntos();
        }
        return p;
    }

    public int nivelActual (String userID) {
        int n = 1; //empezamos en nivel 1
        Juego juego = new Juego();
        int i = 0;
        boolean encontrado = false;
        User user = getUser(userID);
        Partida partida = new Partida();
        if (user != null){
            while (!encontrado) && (i < partidas.size()) {
                if (user.getUserID() == partida.getUserID() ){
                    encontrado = true;
                    juego = partida.getJuegoID(i);
                    n = juego.getNumNiveles();
                }
                i++;
            }


        }
    }

    public String participacion (String userID) {
        String partidas;

        User user = getUser(userID);
        Partida partida = new Partida();
        if (user != null){
            for(int i = 0, i < partidas.size(), i++) {
                if (user.getUserID() == partida.getUserID() ){
 ;                  partidas = partida.getJuegoID();
                }

            }


        }
    }

    private User getUser(String userID) {
        boolean encontrado = false;
        int i = 0;
        User user = new User("", "", "", 50);
        while(!encontrado) && (i< users.size())) {
            user = user.get(i);

            if(user.getUserID().equals(userID)){
                encontrado = true;
            }
            i++;
        }
        return user;
    }




}