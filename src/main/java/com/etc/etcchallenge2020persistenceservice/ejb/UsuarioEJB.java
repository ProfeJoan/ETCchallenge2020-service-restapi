/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */
package com.etc.etcchallenge2020persistenceservice.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.etc.etcchallenge2020persistenceservice.entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Ejecuta las operaciones de persistencia para el objeto Cliente.
 *
 * @author Joan Quesada <joan.quesada at proyectosjo.com>
 */
@Stateless
@LocalBean
public class UsuarioEJB {

    @PersistenceContext
    private EntityManager em;

    /**
     * Ejecuta la persistencia del objeto Usuario.
     *
     * @param usuario
     * @return Éxito o no de la operación.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarUsuario(UsuarioEntity usuario) {
        try {
            UsuarioEntity uExiste = em.find(UsuarioEntity.class, usuario.getId());
            if (uExiste == null) {
                em.persist(usuario);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna todos los usuarios.
     *
     * @return Todos los usuarios.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<UsuarioEntity> obtenerTodosUsuarios() {
        try {
            //Query query = em.createQuery("SELECT c FROM " + UsuarioEntity.class.getName() + " c");
            //return (List<UsuarioEntity>) query.getResultList();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<UsuarioEntity> cq = cb.createQuery(UsuarioEntity.class);
            Root<UsuarioEntity> rootEntry = cq.from(UsuarioEntity.class);
            CriteriaQuery<UsuarioEntity> all = cq.select(rootEntry);

            TypedQuery<UsuarioEntity> allQuery = em.createQuery(all);
            return (List<UsuarioEntity>) allQuery.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * Borra el objeto Usuario identificado por Id.
     *
     * @param id
     * @return Éxito o no de la operación.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean borrarUsuario(String id) {
        try {
            em.remove(em.find(UsuarioEntity.class, id));
            return true;
        } catch (Exception e) {
            return false;
            // Luego debería integrar estas causas de excepción a un Logger.
        }
    }

    /**
     * Buscar el objeto Usuario identificado por Id y si exite valida que la contraseña dada sea correcta.
     *
     * @param id
     * @param contrasena
     * @return Éxito o no de la operación.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public UsuarioEntity validarUsuario(String id, String contrasena) {
        try {
            UsuarioEntity ue = em.find(UsuarioEntity.class, id);
            if (ue.getContrasena().equals(contrasena)) {
                return ue;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

}
