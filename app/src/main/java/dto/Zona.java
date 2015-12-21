package dto;

import java.io.Serializable;

/**
 * Created by dani on 17/12/15.
 */
public class Zona implements Serializable {
    private int idzona;
    private String nombrezona;
    private String urlfotozona;

    public Zona(int idzona, String nombrezona, String urlfotozona) {
        this.idzona = idzona;
        this.nombrezona = nombrezona;
        this.urlfotozona = urlfotozona;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public String getNombre() {
        return nombrezona;
    }

    public void setNombre(String nombre) {
        this.nombrezona = nombrezona;
    }

    public String getUrlfoto() {
        return urlfotozona;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfotozona = urlfotozona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zona zona = (Zona) o;

        return idzona == zona.idzona;

    }

    @Override
    public int hashCode() {
        return idzona;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "idzona=" + idzona +
                ", nombre='" + nombrezona + '\'' +
                ", urlfoto='" + urlfotozona + '\'' +
                '}';
    }
}
