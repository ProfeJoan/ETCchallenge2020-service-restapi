/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */

package com.etc.etcchallenge2020persistenceservice.rest;

import com.etc.etcchallenge2020persistenceservice.ejb.ParqueoEJB;
import javax.ws.rs.Path;
import com.etc.etcchallenge2020persistenceservice.entity.ParqueoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Define las operaciones del Rest API para los Parqueos.
 * @author Joan Quesada <joan.quesada at proyectosjo.com>
 */
@Path("/restapiparqueo")
public class ParqueoEndpoint {

    @EJB
    ParqueoEJB persistenceParqueo;

    /**
     * Implementa la operación POST para agregar el parqueo.
     * @param parqueoJson
     * @return Response con el código de operación exitosa OK o fallida NOT MODIFIED.
     */
    @Path("/agregarparqueo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)//("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean agregarParqueo(JsonObject parqueoJson) {
        try {
            ParqueoEntity parqueo = new ParqueoEntity();
            parqueo.setId(parqueoJson.getString("id").trim());
            parqueo.setNombre(parqueoJson.getString("nombre").trim());
            parqueo.setTelefono(parqueoJson.getString("telefono").trim());
            parqueo.setUbicacion(parqueoJson.getString("ubicacion").trim());

            return persistenceParqueo.insertarParqueo(parqueo);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Implementa la operación GET para obtener todos los parqueos.
     * @return Todos los parqueos.
     */
    @Path("/obtenerparqueos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)//("text/plain")
    //@Consumes(MediaType.APPLICATION_JSON)
    public List<ParqueoEntity> obtenerParqueos() {
        try {
            return persistenceParqueo.obtenerTodosParqueos();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * Implementa la operación DELETE para borrar un parqueo identificado por su Id.
     * @param id
     * @return Response con el código de operación exitosa OK o fallida NOT MODIFIED.
     */
    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean borrarParqueo(@PathParam("id") String id) {
        try {
            return persistenceParqueo.borrarParqueo(id);
        } catch (Exception e) {
            return false;
        }
    }
}
