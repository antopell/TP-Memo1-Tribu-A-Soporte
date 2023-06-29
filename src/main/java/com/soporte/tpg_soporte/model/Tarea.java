package com.soporte.tpg_soporte.model;

public class Tarea {
    private String proyecto;
    private String id;

    public Tarea(String proyecto, String id) {
        this.proyecto = proyecto;
        this.id = id;
    }

    public String getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}