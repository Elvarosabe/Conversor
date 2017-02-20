package com.example.geometapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView elArea; //Para mostrar el resultado del area
    EditText lado,base,alt,rad;
    String lado1,base1,alt1,rad1,arita,perito,volu,concarea;
    Button info,resetear; // Para enviar la informacion
    RadioButton c,cub,tri,cir;

    int flag1,flag2,flag3,flag4;
    Double areat,perimet,volumen,side,bas,altu,radin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Enlace
        lado = (EditText) findViewById(R.id.lado1);
        base = (EditText) findViewById(R.id.base);
        alt = (EditText) findViewById(R.id.alto);
        rad = (EditText) findViewById(R.id.radio);
        elArea = (TextView) findViewById(R.id.elareas);
        info = (Button) findViewById(R.id.info);
        resetear = (Button) findViewById(R.id.reset);
        c = (RadioButton) findViewById(R.id.bcuad);
        cub = (RadioButton) findViewById(R.id.bcubo);
        tri = (RadioButton) findViewById(R.id.btri);
        cir = (RadioButton) findViewById(R.id.bcir);


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.isChecked() == true) {

                    lado1 = lado.getText().toString();
                    flag1 = 1;
                    cub.setEnabled(false);
                    tri.setEnabled(false);
                    cir.setEnabled(false);

                } else if (cub.isChecked() == true) {

                    lado1 = lado.getText().toString();
                    flag2 = 1;
                    c.setEnabled(false);
                    tri.setEnabled(false);
                    cir.setEnabled(false);
                } else if (tri.isChecked() == true) {

                    base1 = base.getText().toString();
                    alt1 = alt.getText().toString();
                    flag3 = 1;
                    cub.setEnabled(false);
                    c.setEnabled(false);
                    cir.setEnabled(false);
                } else if (cir.isChecked() == true) {
                    rad1 = rad.getText().toString();
                    flag4 = 1;
                    cub.setEnabled(false);
                    tri.setEnabled(false);
                    c.setEnabled(false);
                }

                if (flag1 == 1) {
                    side = Double.parseDouble(lado1);
                    areat = side * side;
                    perimet = 4*side;
                    perito = perimet.toString();
                    arita = areat.toString();
                    concarea = "Area :" + arita +" Perimetro:"+perito;
                    elArea.setText(concarea);


                } else if (flag2 == 1) {
                    side = Double.parseDouble(lado1);
                    areat = 6 * side * side;
                    volumen=side*side*side;
                    volu=volumen.toString();
                    arita = areat.toString();
                    concarea = "Area :" + arita+" Volumen: "+volu;
                    elArea.setText(concarea);

                } else if (flag3 == 1) {
                    bas = Double.parseDouble(base1);
                    altu = Double.parseDouble(alt1);
                    areat = ((bas * altu) / 2);
                    arita = areat.toString();
                    concarea = "Area :" + arita;
                    elArea.setText(concarea);
                } else if (flag4 == 1) {
                    radin = Double.parseDouble(rad1);
                    areat = (3.141516) * (radin) * (radin);
                    perimet= (2*(3.141516)*radin);
                    arita = areat.toString();
                    perito = perimet.toString();
                    concarea = "Area :" + arita+" Perimetro:"+perito;
                    elArea.setText(concarea);
                }

            }
        });


        resetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c.setEnabled(true);
                cir.setEnabled(true);
                tri.setEnabled(true);
                cub.setEnabled(true);

              lado.setText("");
                rad.setText("");
                base.setText("");
                alt.setText("");
                elArea.setText("");

                side=0.0;
                bas=0.0;
                altu=0.0;
                radin=0.0;


                lado1 ="";
                base1 ="";
                alt1 ="";
                rad1="";
                arita="";
                perito="";
                volu="";

                flag1=0;
                flag2=0;
                flag3=0;
                flag4=0;

                areat=0.0;
                perimet=0.0;

                c.setChecked(false);
                cir.setChecked(false);
                tri.setChecked(false);
                cub.setChecked(false);
            }
        });

    }

}
