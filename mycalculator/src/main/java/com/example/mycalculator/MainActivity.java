package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText numero; //Instancia para el Edit_text donde se ven los valores
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bmas,bpor,bdiv,bigual,bmenos,bpunto,blimpiar;
    String Acum=""; //Acumulador
    int flag1=0,flag2=0,flag3=0,flag4=0,flagp=0;

    Double Tempo,op1=0.0,op2=0.0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Zona de enlace de mis elementos con las estancias creadas en Java
        numero = (EditText) findViewById(R.id.eNumero); //enlazo mi edittext con mi estancia
        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        bmas = (Button) findViewById(R.id.bmas);
        bpor = (Button) findViewById(R.id.bpor);
        bmenos = (Button) findViewById(R.id.bmenos);
        bpunto = (Button) findViewById(R.id.bpunto);
        bdiv = (Button) findViewById(R.id.bdiv);
        bigual = (Button) findViewById(R.id.bigual);
        blimpiar = (Button) findViewById(R.id.blimpiar);
        //------------------------------------------------------------------


    }

    public void clic(View view){
        int id=view.getId(); //capturo el id del boton que presione
        switch (id)
        {
            case R.id.b0: Acum = Acum + "0";
                    numero.setText(Acum);
                break;
            case R.id.b1: Acum = Acum + "1";
                        numero.setText(Acum);
                break;
            case R.id.b2: Acum = Acum + "2";
                numero.setText(Acum);
                break;
            case R.id.b3: Acum = Acum + "3";
                numero.setText(Acum);
                break;
            case R.id.b4: Acum = Acum + "4";
                numero.setText(Acum);
                break;
            case R.id.b5: Acum = Acum + "5";
                numero.setText(Acum);
                break;
            case R.id.b6: Acum = Acum + "6";
                numero.setText(Acum);
                break;
            case R.id.b7: Acum = Acum + "7";
                numero.setText(Acum);
                break;
            case R.id.b8: Acum = Acum + "8";
                numero.setText(Acum);
                break;
            case R.id.b9: Acum = Acum + "9";
                numero.setText(Acum);
                break;

            case R.id.bpunto:
                if(flagp==0)
                {
                    Acum= Acum +".";
                    numero.setText(Acum);
                    flagp=1;

                }

                break;

            case R.id.bmas:
                op2= Double.parseDouble(Acum); //Conversion de la vble que acumula
                op1 += op2; //Acumulador para posteriores sumas
                Acum="";
                flag1=1;
                flagp=0;
                numero.setText("");

                break;

            case R.id.bmenos:
            {
                op2= Double.parseDouble(Acum); //Conversion del primer dato
                op1 += op2;
                Acum="";
                flag2=1;
                flagp=0;
                numero.setText("");


                break;
            }
            case R.id.bpor:
            {

                op2= Double.parseDouble(Acum); //Conversion de la vble que acumula
                op1 += op2; //Acumulador para posteriores capturas
                Acum=""; //vacio el encargado de la concatenacion
                flag3=1;
                flagp=0;
                numero.setText("");

                break;
            }
            case R.id.bdiv:
            {
                op2= Double.parseDouble(Acum); //Conversion de la vble que acumula
                op1 += op2; //Acumulador para posteriores capturas
                Acum=""; //vacio el encargado de la concatenacion
                flag4=1;
                flagp=0;
                numero.setText("");

                break;
            }
            case R.id.blimpiar:
            {
                Acum="";
                numero.setText("");
                flagp=0;

                op1=0.0;
                break;
            }


            case R.id.bigual:
            {
                flagp=0;
                if (flag1 == 1) {
                    op2 = Double.parseDouble(Acum);
                    Tempo = op1 + op2; // Suma de las variables ingresadas
                    flag1 = 0;
                    numero.setText(Tempo.toString());
                }
                    else if (flag2 == 1)
                        {

                        op2 = Double.parseDouble(Acum); //este es el dato que llega
                        op2 = -op2;
                        Tempo = op1 + op2; // Suma de las variables ingresadas ya en Double
                        op1 = Tempo;
                        flag1 = 0;
                        flag2 = 0;
                        numero.setText(Tempo.toString());
                        Acum = "0";
                        }

                    else if(flag3==1)
                        {
                            op2 = Double.parseDouble(Acum);
                            Tempo = op1*op2; // Suma de las variables ingresadas
                            op1=Tempo;
                            flag1=0;
                            flag2=0;
                            flag3 = 0;
                            numero.setText(Tempo.toString());
                            Acum="0";
                        }
                else if(flag4==1) {
                    op2 = Double.parseDouble(Acum);
                    if (op2 == 0) {
                        numero.setText("Error");

                    } else {
                        Tempo = op1 / op2; // Division de las vbles ingresadas
                        op1 = Tempo;
                        flag1 = 0;
                        flag2 = 0;
                        flag3 = 0;
                        flag4 = 0;
                        numero.setText(Tempo.toString());
                        Acum = "0";
                    }
                }

                break;
            }








        }



    }

}




