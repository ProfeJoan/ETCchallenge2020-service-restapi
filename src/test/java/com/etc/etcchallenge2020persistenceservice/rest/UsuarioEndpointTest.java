/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */
package com.etc.etcchallenge2020persistenceservice.rest;

import com.etc.etcchallenge2020persistenceservice.entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jo
 */
public class UsuarioEndpointTest {
    
    public UsuarioEndpointTest() {
    }

    /**
     * Test of agregarUsuario method, of class UsuarioEndpoint.
     */
    @Test
    public void testAgregarUsuario() {
        System.out.println("agregarUsuario");
        JsonObject clienteJson = null;
        UsuarioEndpoint instance = new UsuarioEndpoint();
        boolean expResult = false;
        boolean result = instance.agregarUsuario(clienteJson);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerUsuarios method, of class UsuarioEndpoint.
     */
    @Test
    public void testObtenerUsuarios() {
        System.out.println("obtenerUsuarios");
        UsuarioEndpoint instance = new UsuarioEndpoint();
        List<UsuarioEntity> expResult = new ArrayList<>();
        List<UsuarioEntity> result = instance.obtenerUsuarios();
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarUsuario method, of class UsuarioEndpoint.
     */
    @Test
    public void testBorrarUsuario() {
        System.out.println("borrarUsuario");
        String id = "";
        UsuarioEndpoint instance = new UsuarioEndpoint();
        boolean expResult = false;
        boolean result = instance.borrarUsuario(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of autenticarUsuario method, of class UsuarioEndpoint.
     */
    @Test
    public void testAutenticarUsuario() {
        System.out.println("autenticarUsuario");
        JsonObject credenciales = null;
        UsuarioEndpoint instance = new UsuarioEndpoint();
        UsuarioEntity expResult = null;
        UsuarioEntity result = instance.autenticarUsuario(credenciales);
        assertEquals(expResult, result);
    }
    
}
