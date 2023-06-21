package com.soporte.tpg_soporte.model;

import com.google.gson.annotations.SerializedName;

public class Version {

    private Long codigo;
    private Long producto;
    private String descripcion;

    public Long getCodigo() {
        return codigo;
    }
    public Long getCodigoProducto() {
        return producto;
    }
    public String getDescripcion() {
        return descripcion;
    }
}