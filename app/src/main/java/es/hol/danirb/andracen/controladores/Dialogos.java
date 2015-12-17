package es.hol.danirb.andracen.controladores;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.afollestad.materialdialogs.MaterialDialog;

import es.hol.danirb.andracen.R;


public class Dialogos {



    public static MaterialDialog.Builder crearDialogoSimpleAceptar(Context context, int titulo, int contenido) {
        return new MaterialDialog.Builder(context)
                .title(titulo)
                .content(contenido)
                .positiveText(context.getString(R.string.aceptar));
    }

    public static MaterialDialog.Builder crearDialogoSimple(Context context, int titulo, int contenido) {
        return new MaterialDialog.Builder(context)
                .title(R.string.guardar)
                .content(contenido)
                .positiveText(context.getString(R.string.aceptar))
                .negativeText(context.getString(R.string.cancelar));
    }

    public static MaterialDialog.Builder crearDialogoSinBotones(Context context, int titulo, int contenido) {
        return new MaterialDialog.Builder(context)
                .title(titulo)
                .content(contenido)
                .widgetColorRes(R.color.contenidoDialogos);
    }

    public static MaterialDialog.Builder crearDialogoSinBotonesConStrings(Context context, String titulo, String contenido) {
        return new MaterialDialog.Builder(context)
                .title(titulo)
                .content(contenido)
                .widgetColorRes(R.color.primaryDark);
    }

    public static MaterialDialog.Builder crearDialogoSastisfactorio(Context context) {
        return new MaterialDialog.Builder(context)
                .title(R.string.importar)
                .content(R.string.dialogo_exito)
                .positiveText(context.getString(R.string.aceptar));
    }

    public static MaterialDialog.Builder crearDialogoErroneo(Context context) {
        return new MaterialDialog.Builder(context)
                .title(R.string.importar)
                .content(R.string.dialogo_fallido)
                .positiveText(context.getString(R.string.aceptar));
    }



}
