package models;

import java.io.Serializable;

/**
 * Created by dani on 17/12/15.
 */
public class Tipo implements Serializable {
    int idtipo;
    String nombretipo;

    public Tipo(int idtipo, String nombretipo) {
        this.idtipo = idtipo;
        this.nombretipo = nombretipo;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombre() {
        return nombretipo;
    }

    public void setNombre(String nombretipo) {
        this.nombretipo = nombretipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tipo tipo = (Tipo) o;

        return idtipo == tipo.idtipo;

    }

    @Override
    public int hashCode() {
        return idtipo;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "idtipo=" + idtipo +
                ", nombretipo='" + nombretipo + '\'' +
                '}';
    }
}
