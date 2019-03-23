package com.example.mapsalud.presentation.main.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class GetDataVM implements Parcelable {


    private int id;
    private String nombre;
    private String apellido;
    private String imagen;

    public GetDataVM() {
    }

    protected GetDataVM(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        apellido = in.readString();
        imagen = in.readString();
    }

    public static final Creator<GetDataVM> CREATOR = new Creator<GetDataVM>() {
        @Override
        public GetDataVM createFromParcel(Parcel in) {
            return new GetDataVM(in);
        }

        @Override
        public GetDataVM[] newArray(int size) {
            return new GetDataVM[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(imagen);
    }
}
