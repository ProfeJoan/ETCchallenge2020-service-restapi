/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */

package com.etc.etcchallenge2020persistenceservice.rest;

import com.etc.etcchallenge2020persistenceservice.ejb.ClienteEJB;
import javax.ws.rs.Path;
import com.etc.etcchallenge2020persistenceservice.entity.ClienteEntity;
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
 * Define las operaciones del Rest API para los Clientes.
 * @author Joan Quesada <joan.quesada at proyectosjo.com>
 */
@Path("/restapicliente")
public class ClienteEndpoint {

    @EJB
    ClienteEJB persistenceCliente;

    /**
     * Implementa la operación POST para agregar el cliente.
     * @param clienteJson
     * @return Response con el código de operación exitosa OK o fallida NOT MODIFIED.
     */
    @Path("/agregarcliente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)//("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean agregarCliente(JsonObject clienteJson) {
try {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(clienteJson.getString("id").trim());
        cliente.setNombre(clienteJson.getString("nombre").trim());
        cliente.setCorreo(clienteJson.getString("correo").trim());
        
            return (persistenceCliente.insertarCliente(cliente));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Implementa la operación GET para obtener todos los clientes.
     * @return Todos los clientes.
     */
    @Path("/obtenerclientes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)//("text/plain")
    //@Consumes(MediaType.APPLICATION_JSON)
    public List<ClienteEntity> obtenerClientes() {
        try {
            return persistenceCliente.obtenerTodosClientes();
        } catch (Exception e){
            return new ArrayList<>();
        }
    }

    /**
     * Implementa la operación DELETE para borrar un cliente identificado por su Id.
     * @param id
     * @return Response con el código de operación exitosa OK o fallida NOT MODIFIED.
     */
    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean borrarCliente(@PathParam("id") String id) {
        try {
            return persistenceCliente.borrarCliente(id);
        } catch (Exception e) {
            return false;
        }
    }
}
