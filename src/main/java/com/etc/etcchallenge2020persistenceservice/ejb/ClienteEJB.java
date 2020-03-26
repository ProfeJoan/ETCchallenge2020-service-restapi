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
import com.etc.etcchallenge2020persistenceservice.entity.ClienteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Ejecuta las operaciones de persistencia para el objeto ClienteEntity.
 *
 * @author Joan Quesada <joan.quesada at proyectosjo.com>
 */
@Stateless
@LocalBean
public class ClienteEJB {

    @PersistenceContext
    private EntityManager em;

    /**
     * Ejecuta la persistencia del objeto ClienteEntity.
     *
     * @param cliente
     * @return Éxito o no de la operación.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarCliente(ClienteEntity cliente) {
        try {
            ClienteEntity cExiste = em.find(ClienteEntity.class, cliente.getId());
            if (cExiste == null) {
                em.persist(cliente);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna todos los clientes.
     *
     * @return Todos los clientes.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<ClienteEntity> obtenerTodosClientes() {
        try {
            //Query query = em.createQuery("SELECT c FROM " + ClienteEntity.class.getName() + " c");
            //return (List<ClienteEntity>) query.getResultList();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ClienteEntity> cq = cb.createQuery(ClienteEntity.class);
            Root<ClienteEntity> rootEntry = cq.from(ClienteEntity.class);
            CriteriaQuery<ClienteEntity> all = cq.select(rootEntry);

            TypedQuery<ClienteEntity> allQuery = em.createQuery(all);
            return (List<ClienteEntity>) allQuery.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * Borra el objeto ClienteEntity identificado por Id.
     *
     * @param id
     * @return Éxito o no de la operación.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean borrarCliente(String id) {
        try {
            em.remove(em.find(ClienteEntity.class, id));
            return true;
        } catch (Exception e) {
            return false;
            // Luego debería integrar estas causas de excepción a un Logger.
        }
        //em.remove(cliente);
    }
}
