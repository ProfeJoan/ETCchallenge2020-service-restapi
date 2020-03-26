/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */
package com.etc.etcchallenge2020persistenceservice.rest;

import com.etc.etcchallenge2020persistenceservice.entity.ClienteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jo
 */
public class ClienteEndpointTest {
    
    public ClienteEndpointTest() {
    }

    /**
     * Test of obtenerClientes method, of class ClienteEndpoint.
     */
    @Test
    public void testObtenerClientes() {
        System.out.println("Inicia la prueba unitaria para obtenerClientes");
        ClienteEndpoint instance = new ClienteEndpoint();
        List<ClienteEntity> expResult = new ArrayList<>();
        List<ClienteEntity> result = instance.obtenerClientes();
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarCliente method, of class ClienteEndpoint.
     */
    @Test
    public void testAgregarCliente() {
        System.out.println("agregarCliente");
        JsonObject clienteJson = null;
        ClienteEndpoint instance = new ClienteEndpoint();
        boolean expResult = false;
        boolean result = instance.agregarCliente(clienteJson);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarCliente method, of class ClienteEndpoint.
     */
    @Test
    public void testBorrarCliente() {
        System.out.println("borrarCliente");
        String id = "";
        ClienteEndpoint instance = new ClienteEndpoint();
        boolean expResult = false;
        boolean result = instance.borrarCliente(id);
        assertEquals(expResult, result);
    }
    
}
