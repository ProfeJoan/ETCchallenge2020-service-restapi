/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */
package com.etc.etcchallenge2020persistenceservice.rest;

import com.etc.etcchallenge2020persistenceservice.entity.ParqueoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jo
 */
public class ParqueoEndpointTest {
    
    public ParqueoEndpointTest() {
    }

    /**
     * Test of obtenerParqueos method, of class ParqueoEndpoint.
     */
    @Test
    public void testObtenerParqueos() {
        System.out.println("Inicia la prueba unitaria para obtenerParqueos");
        ParqueoEndpoint instance = new ParqueoEndpoint();
        List<ParqueoEntity> expResult = new ArrayList<>();
        List<ParqueoEntity> result = instance.obtenerParqueos();
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarParqueo method, of class ParqueoEndpoint.
     */
    @Test
    public void testAgregarParqueo() {
        System.out.println("agregarParqueo");
        JsonObject parqueoJson = null;
        ParqueoEndpoint instance = new ParqueoEndpoint();
        boolean expResult = false;
        boolean result = instance.agregarParqueo(parqueoJson);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarParqueo method, of class ParqueoEndpoint.
     */
    @Test
    public void testBorrarParqueo() {
        System.out.println("borrarParqueo");
        String id = "";
        ParqueoEndpoint instance = new ParqueoEndpoint();
        boolean expResult = false;
        boolean result = instance.borrarParqueo(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarParqueo method, of class ParqueoEndpoint.
     */
    /*@Test
    public void testBorrarParqueo() {
        try {
            System.out.println("Inicia la prueba unitaria para borrarParqueo");
            String id = "";
            ParqueoEndpoint instance = new ParqueoEndpoint();
            Response expResult = null;
            expResult = Response.ok().build();
            Response result = instance.borrarParqueo(id);
            assertEquals(expResult, result);
        } catch (Exception ex) {
            Logger.getLogger(ParqueoEndpointTest.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }*/
}
