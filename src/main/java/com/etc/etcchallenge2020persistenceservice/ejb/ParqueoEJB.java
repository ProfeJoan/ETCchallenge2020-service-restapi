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
import com.etc.etcchallenge2020persistenceservice.entity.ParqueoEntity;
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
public class ParqueoEJB {

    @PersistenceContext
    private EntityManager em;

    /**
     * Ejecuta la persistencia del objeto Parqueo.
     *
     * @param parqueo
     * @return Éxito o no de la operación.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarParqueo(ParqueoEntity parqueo) {
        try {
            ParqueoEntity pExiste = em.find(ParqueoEntity.class, parqueo.getId());
            if (pExiste == null) {
                em.persist(parqueo);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna todos los parqueos.
     *
     * @return Todos los parqueos.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<ParqueoEntity> obtenerTodosParqueos() {
        try {
            //Query query = em.createQuery("SELECT c FROM " + ParqueoEntity.class.getName() + " c");
            //return (List<ParqueoEntity>) query.getResultList();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ParqueoEntity> cq = cb.createQuery(ParqueoEntity.class);
            Root<ParqueoEntity> rootEntry = cq.from(ParqueoEntity.class);
            CriteriaQuery<ParqueoEntity> all = cq.select(rootEntry);

            TypedQuery<ParqueoEntity> allQuery = em.createQuery(all);
            return (List<ParqueoEntity>) allQuery.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * Borra el objeto Parqueo identificado por Id.
     *
     * @param id
     * @return Éxito o no de la operación.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean borrarParqueo(String id) {
        try {
            em.remove(em.find(ParqueoEntity.class, id));
            return true;
        } catch (Exception e) {
            return false;
            // Luego debería integrar estas causas de excepción a un Logger.
        }
    }
}
