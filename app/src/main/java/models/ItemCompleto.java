package models;

import java.io.Serializable;

public class ItemCompleto implements Serializable {
    private int iditem;
    private String nombreitem;
    private int fkidtipo;
    private int fkidzona;
    private int x;
    private int y;

    public ItemCompleto(int iditem, String nombreitem, int fkidtipo, int fkidzona, int x, int y) {
        this.iditem = iditem;
        this.nombreitem = nombreitem;
        this.fkidtipo = fkidtipo;
        this.fkidzona = fkidzona;
        this.x = x;
        this.y = y;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public String getNombreitem() {
        return nombreitem;
    }

    public void setNombreitem(String nombreitem) {
        this.nombreitem = nombreitem;
    }

    public int getFkidtipo() {
        return fkidtipo;
    }

    public void setFkidtipo(int fkidtipo) {
        this.fkidtipo = fkidtipo;
    }

    public int getFkidzona() {
        return fkidzona;
    }

    public void setFkidzona(int fkidzona) {
        this.fkidzona = fkidzona;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemCompleto that = (ItemCompleto) o;

        return iditem == that.iditem;

    }

    @Override
    public int hashCode() {
        return iditem;
    }

    @Override
    public String toString() {
        return "ItemCompleto{" +
                "iditem=" + iditem +
                ", nombreitem='" + nombreitem + '\'' +
                ", fkidtipo=" + fkidtipo +
                ", fkidzona=" + fkidzona +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}


