package com.example.parcial_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView tvname,tvnumber, radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nombre,number,boton;
        tvname = (TextView)findViewById(R.id.txt2_name);
        tvnumber = (TextView)findViewById(R.id.txt2_number);
        radioButton=(TextView) findViewById(R.id.txt2_grupo);

        Bundle contacto = this.getIntent().getExtras();
        if (contacto != null) {
            nombre = contacto.getString("nombre");
            number = contacto.getString("number");
            boton = contacto.getString("grupo");

            tvname.setText(nombre);
            tvnumber.setText(number);
            radioButton.setText(boton);
        }
    }

    public void Volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void  borrarTodo(View view){
        tvname.setText("");
        tvnumber.setText("");
        radioButton.setText("");
    }

    public void ordenApell (View v){
        Toast.makeText(getBaseContext(), "Apellidos en orden alfabetico",Toast.LENGTH_SHORT).show();
    }

    public void ordenGrupo (View v){
        Toast.makeText(getBaseContext(), "Grupo en orden alfabetico",Toast.LENGTH_SHORT).show();
    }

    public void listaInv (View v){
        Toast.makeText(getBaseContext(), "Lista invertida",Toast.LENGTH_SHORT).show();
    }

}
