package com.example.pelicool;

import android.os.Parcel;
import android.os.Parcelable;

public class Pelicula  implements Parcelable {

    private String pelicula, director, tipo, idioma;

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Pelicula(String pelicula, String director, String tipo, String idioma) {
        this.pelicula = pelicula;
        this.director = director;
        this.tipo = tipo;
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return  "pelicula=" + pelicula + '\'' +
                "director=" + director + '\'' +
                "tipo= " + tipo + '\'' +
                "idioma='" + idioma + '\'';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pelicula);
        dest.writeString(this.director);
        dest.writeString(this.idioma);
        dest.writeString(this.tipo);


    }

    public static final Creator<Pelicula> CREATOR = new Creator<Pelicula>() {
        @Override
        public Pelicula createFromParcel(Parcel in) {
            return new Pelicula(in);
        }

        @Override
        public Pelicula[] newArray(int size) {
            return new Pelicula[size];
        }
    };

    public Pelicula(Parcel in) {

        this.pelicula = in.readString();
        this.director = in.readString();
        this.idioma = in.readString();
        this.tipo = in.readString();
    }
}