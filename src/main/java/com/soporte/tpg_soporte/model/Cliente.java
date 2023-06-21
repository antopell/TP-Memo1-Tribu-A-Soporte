package com.soporte.tpg_soporte.model;

import com.google.gson.annotations.SerializedName;

public class Cliente {
    private Long id;
    @SerializedName("razon social")
    private String razonSocial;
    private String CUIT;

    public Long getId() {
        return id;
    }
    public String getRazonSocial() {
        return razonSocial;
    }

    public String getCUIT() {
        return CUIT;
    }
}