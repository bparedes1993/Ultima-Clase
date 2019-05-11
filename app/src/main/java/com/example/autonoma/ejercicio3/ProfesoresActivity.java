package com.example.autonoma.ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;
import android.content.Intent; //No olvides importar la dependencia

public class ProfesoresActivity extends AppCompatActivity {

    EditText etNombre;
    Button btnGrebar;
    ArrayList Profesores;
    ListView lvProfesores;

    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);
        //
        etNombre= findViewById(R.id.etNombre);
        btnGrebar= findViewById(R.id.btnAgregar);
        lvProfesores = findViewById(R.id.lvProfesores);
        // inicializamos el array
        Profesores = new ArrayList<String>();
        //adaptadoir
        adapter=        new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        Profesores);
        //asignamos adaptador al list view
        lvProfesores.setAdapter(adapter);
        //
        btnGrebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profesores.add(etNombre.getText().toString());
                lvProfesores.deferNotifyDataSetChanged();
            }
        });


    }// fin onCreate

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle("Profesor:" + Profesores.get(((AdapterView.AdapterContextMenuInfo) info).position));

        inflater.inflate(R.menu.menu_contextual,menu);
    }// fin metodo onCreateContext

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.menu_eliminar:
            Profesores.remove(info.position);
            adapter.notifyDataSetChanged();

            return true;
            default:
                return super.onContextItemSelected(item);
        }



    }//fin onContext

    //detectar click

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add_item:
                Toast.makeText(ProfesoresActivity.this,
                        "Agregar Item",
                        Toast.LENGTH_LONG).show();
                Profesores.add("Profesor X");
                adapter.notifyDataSetChanged();
                return true;

                case R.id.menu_refrescar:
                    Toast.makeText(ProfesoresActivity.this,
                            "Refrescar",
                            Toast.LENGTH_LONG).show();
                    //refrescar adaptador
                    adapter.notifyDataSetChanged();

                    return true;

                case R.id.menu_vermapa:
                    Intent intent = new Intent(
                            ProfesoresActivity.this,
                            MapsActivity.class);
                    //Ir a Profesor Activity
                    startActivity(intent);
                    Toast.makeText(ProfesoresActivity.this,
                            "Ver Mapa",
                            Toast.LENGTH_LONG).show();

                    return true;

                case R.id.menu_cerrar:


                    Toast.makeText(ProfesoresActivity.this,
                            "Cerrar",
                            Toast.LENGTH_LONG).show();

                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            } // fin switch
            } // fin onOptions
        }
















