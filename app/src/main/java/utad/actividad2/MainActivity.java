package utad.actividad2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText txtDentro;
    public EditText txtFuera;
    public long TiempoIni;
    public long TiempoFin;
    public long Total;
    public boolean one;
    public String stringDentro;
    public String stringFuera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDentro = (EditText) this.findViewById(R.id.txtDentro);
        txtFuera = (EditText) this.findViewById(R.id.txtFuera);

        TiempoIni = System.currentTimeMillis();

        // Un minuto despues
    }
    @Override
    protected void onPause() {
        super.onPause();
        one=true;
        TiempoFin = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(one) {
                        Total = System.currentTimeMillis();
                        stringDentro = TiempoIni - TiempoFin + "";
                        stringFuera = TiempoFin - TiempoIni + "";
                        txtDentro.setText((TiempoFin - TiempoIni) / 1000 + "," + stringDentro.substring(2) + " segundos");
                        txtFuera.setText("En segundo plano " +(Total - TiempoFin) / 1000 + "," + stringFuera.substring(2) + " segundos");
                    }

    }
}
