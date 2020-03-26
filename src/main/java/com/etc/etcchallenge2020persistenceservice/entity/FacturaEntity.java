/*
 * Desarrollado con gusto por Joan Quesada.
 * La re-distribución de este código queda a discreción
 * del supracitado desarrollador y su empresa.
 */
package com.etc.etcchallenge2020persistenceservice.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Define el mapeo del POJO, junto con la implementación de sus getters y setters.
 * @author Joan Quesada <joan.quesada at proyectosjo.com>
 */
@Entity
@Table(name = "facturas")
public class FacturaEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "id_cliente")
    private String idCliente;
    @Column(name = "id_parqueo")
    private String idParqueo;
    @Column(name = "monto")
    private double monto;

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @return
     */
    public String getIdParqueo() {
        return idParqueo;
    }

    /**
     *
     * @param idParqueo
     */
    public void setIdParqueo(String idParqueo) {
        this.idParqueo = idParqueo;
    }

    /**
     *
     * @return
     */
    public double getMonto() {
        return monto;
    }

    /**
     *
     * @param monto
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    
}
