package com.example.resistenciapp;

import android.app.Activity;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    String b1,b2,b3,aux,s,tole;
    int pb=0,sb=0,tb=1,restotal=0,sig;
    TextView muestre;
    Double flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        muestre = (TextView) findViewById(R.id.mostrar);

        //Instancie y enlace en el mismo punto
        Spinner spinner = (Spinner) findViewById(R.id.primerabanda); //Enlace primera banda
        Spinner spinner2 = (Spinner) findViewById(R.id.segundabanda); //Enlace segunda banda
        Spinner spinner3 = (Spinner) findViewById(R.id.tercerabanda);//Enlace tercera banda
        Spinner spinnert = (Spinner) findViewById(R.id.tol);//Enlace tolerancia

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.opciones,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //------*** Defino caracteristicas del spinner para la tolerancia --------------
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(this,R.array.Toler,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //---------+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter); //aplico el spinner a mi primera banda
        spinner2.setAdapter(adapter);//aplico el spinner a mi segunda banda
        spinner3.setAdapter(adapter);//aplico el spinner a mi tercera banda
        spinnert.setAdapter(adapter1);//aplico el spinner a mi banda de tolerancia


        //Respuesta a las selecciones del usuario

        //Primera Banda
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                parent.getItemAtPosition(position);

                pb=position;

                restotal=(pb*10+sb)*tb;
                aux = Integer.toString(restotal);
                muestre.setText(aux+tole);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //Segunda banda

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {


                parent.getItemAtPosition(position);

                sb=position;

                restotal=(pb*10+sb)*tb;
                aux = Integer.toString(restotal);
                muestre.setText(aux+tole);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //Tercera banda Multiplicadora

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {



                parent.getItemAtPosition(position);

                tb=position;
                s=Integer.toString(tb);

                flag=Double.parseDouble(s);

                flag=Math.pow(10.0,flag);

                tb=flag.intValue();

                restotal= (pb*10+sb)*tb;
                aux = Integer.toString(restotal);
                muestre.setText(aux+tole);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinnert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                parent.getItemAtPosition(position);

                sig=position;
                switch (sig)
                {
                    case 0:
                        tole = " 10 %  tolerancia";
                        break;
                    case 1:
                        tole = " 5 % tolerancia";
                        break;
                }


                restotal= (pb*10+sb)*tb;
                aux = Integer.toString(restotal);
                muestre.setText(aux+tole);


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }









}
