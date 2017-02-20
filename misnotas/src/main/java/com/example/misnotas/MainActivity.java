package com.example.misnotas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText practica,avance,avancedos,avancetres,avfinal;
    Button informacion;
    TextView mostrar;


    String p,av1,av2,av3,pf,totalt;
    Double prac,a1,a2,a3,fin,totalidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazando mis instancias con las de la interfaz
        practica = (EditText) findViewById(R.id.practica);
        avance   = (EditText) findViewById(R.id.avance1);
        avancedos= (EditText) findViewById(R.id.avance2);
        avancetres=(EditText) findViewById(R.id.avance3);
        avfinal  = (EditText) findViewById(R.id.pfinal);
        informacion= (Button) findViewById(R.id.promedio);
        mostrar  = (TextView) findViewById(R.id.total);



        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Obteniendo la informacion
                p = practica.getText().toString();
                av1=avance.getText().toString();
                av2=avancedos.getText().toString();
                av3=avancetres.getText().toString();
                pf=avfinal.getText().toString();

                //Haciendo el casting a Double
                prac = Double.parseDouble(p);
                a1   = Double.parseDouble(av1);
                a2   = Double.parseDouble(av2);
                a3   = Double.parseDouble(av3);
                fin  = Double.parseDouble(pf);

                totalidad = (prac*0.6)+(a1*0.05)+(a2*0.07)+(a3*0.08)+(fin*0.2);
                totalt = totalidad.toString();
                mostrar.setText(totalt);


                if (totalidad<=1)
                {
                    Toast.makeText(getApplicationContext(),"Estas en el lugar equivocado ",Toast.LENGTH_SHORT).show();

                }
                else if(totalidad >= 1.1 && totalidad <=2)
                {

                    Toast.makeText(getApplicationContext()," Remal ",Toast.LENGTH_SHORT).show();

                }
                else if (totalidad >=2.1 && totalidad <=3)
                {

                    Toast.makeText(getApplicationContext()," Es posible recuperarse ",Toast.LENGTH_SHORT).show();

                }
                else if (totalidad >=3.1 && totalidad <=4)
                {
                    Toast.makeText(getApplicationContext()," Normalito ",Toast.LENGTH_SHORT).show();
                }
                else if (totalidad >=4.1 && totalidad <=4.5)
                {
                    Toast.makeText(getApplicationContext()," Muy Bien ",Toast.LENGTH_SHORT).show();
                }
                else if (totalidad >=4.6 && totalidad <=5)
                {
                    Toast.makeText(getApplicationContext()," Excelente Estudiante ",Toast.LENGTH_SHORT).show();
                }




            }
        });




















    }
}
