/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */
package com.etc.etcchallenge2020persistenceservice.ejb;

import com.etc.etcchallenge2020persistenceservice.entity.ClienteEntity;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jo
 */
public class ClienteEJBTest {
    
    public ClienteEJBTest() {
    }

    /**
     * Test of insertarCliente method, of class ClienteEJB.
     */
    @Test
    public void testInsertarCliente() {
        System.out.println("insertarCliente");
        ClienteEntity cliente = null;
        boolean expResult = false;
        boolean result = new ClienteEJB().insertarCliente(cliente);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodosClientes method, of class ClienteEJB.
     */
    @Test
    public void testObtenerTodosClientes() {
        System.out.println("obtenerTodosClientes");
        List<ClienteEntity> expResult = new ArrayList<>();
        List<ClienteEntity> result = new ClienteEJB().obtenerTodosClientes();
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarCliente method, of class ClienteEJB.
     */
    @Test
    public void testBorrarCliente() {
        System.out.println("borrarCliente");
        String id = "";
        boolean expResult = false;
        boolean result = new ClienteEJB().borrarCliente(id);
        assertEquals(expResult, result);
    }
    
}
