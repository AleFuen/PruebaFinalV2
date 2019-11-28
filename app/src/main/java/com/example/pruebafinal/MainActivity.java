package com.example.pruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtCodigo, edtCurso, edtCarrera;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCodigo=(EditText)findViewById(R.id.edtCodigo);
        edtCurso=(EditText)findViewById(R.id.edtCurso);
        edtCarrera=(EditText)findViewById(R.id.edtCarrera);
        btnAgregar=(Button) findViewById(R.id.btnAgregar);

        final Formulario_DB formulario_db = new Formulario_DB(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formulario_db.agregarCursos(edtCodigo.getText().toString(),edtCurso.getText().toString(),edtCarrera.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
