package dto;

import java.io.Serializable;

/**
 * Created by dani on 14/12/15.
 */
public class Item implements Serializable{
    private int iditem;
    private  String nombreitem;
    private String nombretipo;
    private String nombrezona;
    private int y;
    private int x;


    public Item(int iditem, String nombreitem, String nombretipo, String nombrezona, int y, int x) {
        this.iditem = iditem;
        this.nombreitem = nombreitem;
        this.nombretipo = nombretipo;
        this.nombrezona = nombrezona;
        this.y = y;
        this.x = x;
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

    public String getNombretipo() {
        return nombretipo;
    }

    public void setNombretipo(String nombretipo) {
        this.nombretipo = nombretipo;
    }

    public String getNombrezona() {
        return nombrezona;
    }

    public void setNombrezona(String nombrezona) {
        this.nombrezona = nombrezona;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return iditem == item.iditem;

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int hashCode() {
        return iditem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "iditem=" + iditem +
                ", nombreitem='" + nombreitem + '\'' +
                ", nombretipo='" + nombretipo + '\'' +
                ", nombrezona='" + nombrezona + '\'' +
                ", y=" + y +
                ", x=" + x +
                '}';
    }
}


