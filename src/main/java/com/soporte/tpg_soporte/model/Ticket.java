package com.soporte.tpg_soporte.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tickets")
public class Ticket {

    public enum Severidad {S1, S2, S3, S4};
    public enum Prioridad {ALTA, MEDIA, BAJA};
    public enum Estado {PENDIENTE, EMPEZADO, RESUELTO};

    @Id
    private String codigo;
    private String titulo;
    private Severidad severidad;
    private Prioridad prioridad;
    private Estado estado;
    private String description;
    private Date sla;
    private Date fechaCreacion;

    private Long cliente;

    private Long producto;


    public Ticket(String codigo, String titulo, Severidad severidad, Prioridad prioridad, Estado estado, String description, Date sla, Date fechaCreacion, Long cliente, Long producto) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.severidad = severidad;
        this.prioridad = prioridad;
        this.estado = estado;
        this.description = description;
        this.sla = sla;
        this.fechaCreacion = fechaCreacion;
        this.cliente = cliente;
        this.producto = producto;
    }


    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Severidad getSeveridad() {
        return this.severidad;
    }

    public void setSeveridad(Severidad severidad) {
        this.severidad = severidad;
    }

    public Prioridad getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSla() {
        return this.sla;
    }

    public void setSla(Date sla) {
        this.sla = sla;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getCliente() {
        return this.cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getProducto() {
        return this.producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }
    

}