package es.hol.danirb.andracen.controladores;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.MaterialModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dani on 15/12/15.
 */
public class Aplicacion extends Application
{
    public static final String RUTA = Environment.getExternalStorageDirectory().getPath() + "/andracen/";
    private static Aplicacion instance;
    private static Configuracion configuracion;

    public static Aplicacion getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify
                .with(new FontAwesomeModule())
                .with(new MaterialModule());
        instance = this;
        configuracion = new Configuracion(this);
    }
    public static Configuracion getConfiguracion() {
        return configuracion;
    }

}

