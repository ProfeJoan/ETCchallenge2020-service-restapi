/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */
package com.etc.etcchallenge2020persistenceservice.ejb;

import com.etc.etcchallenge2020persistenceservice.entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jo
 */
public class UsuarioEJBTest {
    
    public UsuarioEJBTest() {
    }

    /**
     * Test of insertarUsuario method, of class UsuarioEJB.
     */
    @Test
    public void testInsertarUsuario() {
        System.out.println("insertarUsuario");
        UsuarioEntity usuario = null;
        boolean expResult = false;
        boolean result = new UsuarioEJB().insertarUsuario(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodosUsuarios method, of class UsuarioEJB.
     */
    @Test
    public void testObtenerTodosUsuarios() {
        System.out.println("obtenerTodosUsuarios");
        List<UsuarioEntity> expResult = new ArrayList<>();
        List<UsuarioEntity> result = new UsuarioEJB().obtenerTodosUsuarios();
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarUsuario method, of class UsuarioEJB.
     */
    @Test
    public void testBorrarUsuario() {
        System.out.println("borrarUsuario");
        String id = "";
        boolean expResult = false;
        boolean result = new UsuarioEJB().borrarUsuario(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarUsuario method, of class UsuarioEJB.
     */
    @Test
    public void testValidarUsuario() {
        System.out.println("validarUsuario");
        String id = "";
        String contrasena = "";
        UsuarioEntity expResult = null;
        UsuarioEntity result = new UsuarioEJB().validarUsuario(id, contrasena);
        assertEquals(expResult, result);
    }
    
}
