package es.hol.danirb.andracen.controladores;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.andreabaccega.formedittextvalidator.DomainValidator;
import com.andreabaccega.formedittextvalidator.IpAddressValidator;
import com.andreabaccega.formedittextvalidator.OrValidator;
import com.andreabaccega.widget.FormEditText;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.MaterialIcons;

import java.util.Locale;

import es.hol.danirb.andracen.R;

/**
 * Created by dani on 15/12/15.
 */
public class ConfiguracionActivity  extends AppCompatActivity implements View.OnFocusChangeListener {

    private Configuracion configuracion = Aplicacion.getConfiguracion();
    private FormEditText ipValue;
    private EditText portValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = new Configuration();
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.layout_activity_configuracion);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(new IconDrawable(this, MaterialIcons.md_arrow_back).colorRes(R.color.primaryDark).actionBarSize());
        actionBar.setDisplayHomeAsUpEnabled(true);

        ipValue = (FormEditText) findViewById(R.id.config_ip_valor);
        ipValue.setOnFocusChangeListener(this);
        ipValue.setText(configuracion.getIp());
        ipValue.addValidator(createValidator());
        portValue = (EditText) findViewById(R.id.config_puerto_valor);
        portValue.setOnFocusChangeListener(this);
        portValue.setText(configuracion.getPuerto());

    }

    @Override
    public void onBackPressed() {
        showDialog();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }


    private void showDialog() {
        new MaterialDialog.Builder(this)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        guardarDatos();
                    }
                })
                .onNeutral(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        // TODO
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                        finish();
                    }
                })
                .title(R.string.guardar)
                .content(R.string.pregunta_guardar_configuracion)
                .positiveText(this.getString(R.string.aceptar))
                .negativeText(this.getString(R.string.cancelar))
                .show();
    }

    private void guardarDatos() {
        if (ipValue.testValidity()) {
            saveData();
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }


    public void saveData() {
        configuracion.setIp(ipValue.getText().toString());
        configuracion.setPuerto(portValue.getText().toString());
    }



    private OrValidator createValidator() {
        return new OrValidator(
                getString(R.string.ip_dominio_incorrecto),
                new IpAddressValidator(getString(R.string.ip_incorrecta)),
                new DomainValidator(getString(R.string.dominio_incorrecto))
        );
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            int pL = v.getPaddingLeft();
            int pT = v.getPaddingTop();
            int pR = v.getPaddingRight();
            int pB = v.getPaddingBottom();
            v.setBackgroundResource(R.drawable.borde_foco);
            v.setPadding(pL, pT, pR, pB);

        } else {
            int pL = v.getPaddingLeft();
            int pT = v.getPaddingTop();
            int pR = v.getPaddingRight();
            int pB = v.getPaddingBottom();
            v.setBackgroundResource(R.drawable.borde);
            v.setPadding(pL, pT, pR, pB);
        }
    }

    private String getIPDomainValue() {
        return ipValue.getText().toString();
    }

    private String getPort() {
        return portValue.getText().toString();
    }

    public String getHostPort() {

        return getIPDomainValue() + ":" + getPort();
    }



    @Override
    protected void onResume() {
        super.onResume();
        ipValue.setText(configuracion.getIp());
        portValue.setText(configuracion.getPuerto());
    }
}