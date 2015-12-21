package rest;


import android.content.Context;
import android.content.SharedPreferences;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import es.hol.danirb.andracen.controladores.Aplicacion;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by dani on 17/11/15.
 */
public class ServiceGenerator {
    //    public static final String API_BASE_URL = "http://your.api-base.url";
    private static String API_BASE_URL = Aplicacion.getConfiguracion().getURL();
    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
