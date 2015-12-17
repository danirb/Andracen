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

    public Item(int iditem, String nombretipo, String nombreitem, String nombrezona) {
        this.iditem = iditem;
        this.nombretipo = nombretipo;
        this.nombreitem = nombreitem;
        this.nombrezona = nombrezona;
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
    public String toString() {
        return "Item{" +
                "iditem=" + iditem +
                ", nombreitem='" + nombreitem + '\'' +
                ", nombretipo='" + nombretipo + '\'' +
                ", nombrezona='" + nombrezona + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return iditem == item.iditem;

    }

    @Override
    public int hashCode() {
        return iditem;
    }
}


