import android.content.Context;
import android.content.SharedPreferences;

public class Configuracion {

        private static Configuracion configuracion = null;
        private final String IP = "ip";
        private final String PUERTO = "puerto";
        private SharedPreferences sharedPreferences;
        private SharedPreferences.Editor editor;

        public Configuracion(Context context) {
                this.sharedPreferences = context.getSharedPreferences("configuracion", Context.MODE_PRIVATE);
                this.editor = this.sharedPreferences.edit();
        }

        public String getIp() {
                return this.sharedPreferences.getString(IP, "192.168.168.1.15");
        }

        public void setIp(String ip) {
                setValue(IP, ip);
        }

        public String getPuerto() {
                return this.sharedPreferences.getString(PUERTO, "3000");
        }

        public void setPuerto(String puerto) {
                setValue(PUERTO, puerto);
        }



        public boolean isSetHostPort(){
                return !getIp().equals("") && !getPuerto().equals("");
        }


        private void setValue(String key, String value) {
                this.editor.putString(key, value);
                this.editor.apply();
        }

        public String getURL() {
                return "http://" + getHostPort() + "/andracen/";
        }
        public String getHostPort(){
                return getIp()+":"+getPuerto();
        }
}