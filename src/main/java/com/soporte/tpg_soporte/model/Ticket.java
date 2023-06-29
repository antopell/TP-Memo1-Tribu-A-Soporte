package com.soporte.tpg_soporte.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Date fechaLimite;
    private Date fechaCreacion;
    private Long cliente;
    private Long versionProducto;
    private List<Tarea> tareas;


    public Ticket(String codigo, String titulo, Severidad severidad, Prioridad prioridad, 
                    Estado estado, String description, Date fechaLimite, Date fechaCreacion, Long cliente, Long versionProducto,
                    List<Tarea> tareas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.severidad = severidad;
        this.prioridad = prioridad;
        this.estado = estado;
        this.description = description;
        this.fechaLimite = fechaLimite;
        this.fechaCreacion = fechaCreacion;
        this.cliente = cliente;
        this.versionProducto = versionProducto;
        if (tareas == null) tareas = new ArrayList<Tarea>();
        this.tareas = tareas;
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

    public Date getFechaLimite() {
        return this.fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
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

    public Long getVersionProducto() {
        return this.versionProducto;
    }

    public void setVersionProducto(Long versionProducto) {
        this.versionProducto = versionProducto;
    }

    public List<Tarea> getTareas() {
        return this.tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
    

}