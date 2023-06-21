package com.soporte.tpg_soporte.model;

import com.google.gson.annotations.SerializedName;

public class Producto {
    private Long codigo;
    private String titulo;

    public Long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
}