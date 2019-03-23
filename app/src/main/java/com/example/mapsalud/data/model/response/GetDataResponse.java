package com.example.mapsalud.data.model.response;

import com.google.gson.annotations.SerializedName;

public class GetDataResponse {

    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String nombre;
    @SerializedName("last_name")
    private String apellido;
    @SerializedName("avatar")
    private String imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
