/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */

package com.etc.etcchallenge2020persistenceservice.rest;

import com.etc.etcchallenge2020persistenceservice.ejb.UsuarioEJB;
import javax.ws.rs.Path;
import com.etc.etcchallenge2020persistenceservice.entity.UsuarioEntity;
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
 * Define las operaciones del Rest API para los Usuarios.
 * @author Joan Quesada <joan.quesada at proyectosjo.com>
 */
@Path("/restapiusuario")
public class UsuarioEndpoint {

    @EJB
    UsuarioEJB persistenceUsuario;

    /**
     * Implementa la operación POST para agregar el usuario.
     * @param clienteJson
     * @return Response con el código de operación exitosa OK o fallida NOT MODIFIED.
     */
    @Path("/agregarusuario")
    @POST
    @Produces(MediaType.APPLICATION_JSON)//("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean agregarUsuario(JsonObject clienteJson) {
        try {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId(clienteJson.getString("id").trim());
            usuario.setContrasena(clienteJson.getString("contrasena").trim());
            usuario.setPerfil(clienteJson.getString("perfil").trim());

            return persistenceUsuario.insertarUsuario(usuario);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Implementa la operación GET para obtener todos los usuarios.
     * @return Todos los usuarios.
     */
    @Path("/obtenerusuarios")
    @GET
    @Produces(MediaType.APPLICATION_JSON)//("text/plain")
    //@Consumes(MediaType.APPLICATION_JSON)
    public List<UsuarioEntity> obtenerUsuarios() {
        try {
            return persistenceUsuario.obtenerTodosUsuarios();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * Implementa la operación DELETE para borrar un usuario identificado por su Id.
     * @param id
     * @return Response con el código de operación exitosa OK o fallida NOT MODIFIED.
     */
    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean borrarUsuario(@PathParam("id") String id) {
        try {
            return persistenceUsuario.borrarUsuario(id);
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Implementa la operación POST para validar que un usuario exista y su contraseña sea correcta.
     * @param credenciales
     * @return Response con el código de operación exitosa OK o fallida NOT MODIFIED.
     */
    @Path("/autenticacion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)//("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    public UsuarioEntity autenticarUsuario(JsonObject credenciales) {
        try {
            return persistenceUsuario.validarUsuario(credenciales.getString("id"), credenciales.getString("contrasena"));
        } catch (Exception e) {
            return null;
        }
    }
}
