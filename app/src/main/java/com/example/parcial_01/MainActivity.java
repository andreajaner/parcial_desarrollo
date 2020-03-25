package com.example.parcial_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etname, etnumber;
    RadioGroup radioGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText)findViewById(R.id.txt_name);
        etnumber = (EditText)findViewById(R.id.txt_number);
        radioGroup = findViewById(R.id.radioGroup);

        TextView textView = findViewById(R.id.Cambiar);
        registerForContextMenu(textView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Cambiar");
        getMenuInflater().inflate(R.menu.float_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.opcion_1:
                etname.setText(etname.getText().toString().toUpperCase());
                return true;
            case R.id.opcion_2:
                etname.setText(etname.getText().toString().toLowerCase());
                return true;
            default: return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.btnShare:
                etname.setText("");
                etnumber.setText("");
                break;
            case R.id.btnContact:
                Intent ingr = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(ingr);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Grupo: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    public void Registrar (View view){
        String nombre = etname.getText().toString();
        String numero = etnumber.getText().toString();

        if (nombre.length() == 0){
            Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_LONG).show();
        }
        if (numero.length() == 0){
            Toast.makeText(this, "Debes ingresar un numero", Toast.LENGTH_LONG).show();
        }

        if(nombre.length()!= 0 && numero.length() != 0 && radioGroup.getCheckedRadioButtonId() != -1){
            Toast.makeText(this, "Contacto guardado", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, Main2Activity.class);
            i.putExtra("nombre", etname.getText().toString());
            i.putExtra("number", etnumber.getText().toString());
            i.putExtra("grupo", radioButton.getText().toString());
            startActivity(i);

        }

        if (radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Selecciona un grupo", Toast.LENGTH_LONG).show();

        }
    }

    /*public void Enviar (View v){

        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("nombre", etname.getText().toString());
        i.putExtra("number", etnumber.getText().toString());
        i.putExtra("grupo", radioButton.getText().toString());
        startActivity(i);
    }*/

    public void metAleat(View v) {
        int  x, n1, n2;
        Random random = new Random();
        x = random.nextInt(3);

        n1 = random.nextInt(899) + 100;
        n2 = random.nextInt(8999) + 1000;

        String nRand = ("3"+x+"0"+n1+n2);
        etnumber.setText(nRand);
        etnumber.setError(null);
    }

    public void finalizar (View v){
        finish();
    }

}
