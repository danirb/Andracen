package rest;

import java.util.List;

import dto.ItemCompleto;
import dto.Tipo;
import dto.Zona;
import models.Item;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by dani on 14/12/15.
 */
public interface Service {

    @GET("items")
    Call<List<Item>> repoItems();

    @GET("item/{id}")
    Call<ItemCompleto> getItem(@Path("id") int id);

    @GET("zonas")
    Call<List<Zona>> getZonas();

    @GET("tipos")
    Call<List<Tipo>> getTipos();

    @GET("itemportipo/{nombretipo}")
    Call<List<Item>> getItemPorTipo(@Path("nombretipo") String nombretipo);

    @GET("itemporzona/{nombrezona}")
    Call<List<Item>> getItemPorZona(@Path("nombrezona") String nombrezona);

}

