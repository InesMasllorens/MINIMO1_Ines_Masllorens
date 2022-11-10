package edu.upc.dsa.services;


import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Partida;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/tracks", description = "Endpoint to Track Service")
@Path("/tracks")
public class PartidaService {

    private JuegoManager jm;

    public PartidaService() {
        this.jm = JuegoManagerImpl.getInstance();
        if (jm.size()==0) {
            this.jm.addPartida("1111111", "11");
            this.jm.addPartida("1111111", "22");
            this.jm.addPartida("2222222", "11");
        }


    }

    @GET
    @ApiOperation(value = "get all Partidas", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Juego.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPartidas() {

        List<Juego> juegos = this.jm.findAll();

        GenericEntity<List<Juego>> entity = new GenericEntity<List<Juego>>(juegos) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Partida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Juego.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPartida(@PathParam("userID", "juegoID") String userID, String juegoID) {
        Juego t = this.jm.getPartida(userID, juegoID);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Parrida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deletePartida(@PathParam("userID", "juegoID") String userID, String juegoID) {
        Juego t = this.jm.getPartida(userID, juegoID);
        if (t == null) return Response.status(404).build();
        else this.jm.deletePartida(userID,juegoID);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Partida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updatePartida(Partida partida) {

        Juego t = this.jm.updateTrack(partida);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Partida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPartida(Partida partida) {

        if (partida.getUserID()==null || partida.getUserID()==null)  return Response.status(500).entity(partida).build();
        this.jm.addPartida(partida);
        return Response.status(201).entity(partida).build();
    }

}