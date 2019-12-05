package cl.ejercicios.calendario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etFecha=(EditText)findViewById(R.id.etFecha);
        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.etFecha:
                        mostrarCalendario();
                        break;
                }
            }
        });
    }
    private void mostrarCalendario()
    {
        //Primero se hace DatePickerFragment

        DatePickerFragment nuevoFragment=DatePickerFragment.instancia(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day)
                    {
                        final String fecha=day + " / " + (month+1) + " / " + year;
                        EditText etFecha=(EditText) findViewById(R.id.etFecha);
                        etFecha.setText(fecha);
                    }
                }
        );
        nuevoFragment.show(getSupportFragmentManager(),"datepicker");
    }
}
