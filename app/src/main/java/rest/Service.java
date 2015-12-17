package rest;

import android.database.Observable;

import java.util.List;

import dto.Item;
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
    Observable<Item> getItem(@Path("id") int id);

}

