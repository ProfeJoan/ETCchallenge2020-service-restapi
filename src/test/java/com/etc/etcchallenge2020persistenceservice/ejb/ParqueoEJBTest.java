/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */
package com.etc.etcchallenge2020persistenceservice.ejb;

import com.etc.etcchallenge2020persistenceservice.entity.ParqueoEntity;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jo
 */
public class ParqueoEJBTest {
    
    public ParqueoEJBTest() {
    }

    /**
     * Test of insertarParqueo method, of class ParqueoEJB.
     */
    @Test
    public void testInsertarParqueo() {
        System.out.println("insertarParqueo");
        ParqueoEntity parqueo = null;
        boolean expResult = false;
        boolean result = new ParqueoEJB().insertarParqueo(parqueo);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodosParqueos method, of class ParqueoEJB.
     */
    @Test
    public void testObtenerTodosParqueos() {
        System.out.println("obtenerTodosParqueos");
        List<ParqueoEntity> expResult = new ArrayList<>();
        List<ParqueoEntity> result = new ParqueoEJB().obtenerTodosParqueos();
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarParqueo method, of class ParqueoEJB.
     */
    @Test
    public void testBorrarParqueo() {
        System.out.println("borrarParqueo");
        String id = "";
        boolean expResult = false;
        boolean result = new ParqueoEJB().borrarParqueo(id);
        assertEquals(expResult, result);
    }
    
}
