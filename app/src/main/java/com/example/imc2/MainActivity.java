package com.example.imc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText peso, altura;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.editTextPeso);
        altura = findViewById(R.id.editTextAltura);
        btCalcular = findViewById(R.id.buttonCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //capturar os dados informados
                String varPeso = peso.getText().toString();
                String varAltura = altura.getText().toString();
                //vamos criar os pacotes que recebera os dados (varPeso e varAltura)
                Bundle pacote = new Bundle();

                //colocar os dados dentro do pacote

                pacote.putString("varPeso", varPeso);
                pacote.putString("varAltura", varAltura);


                //criar um objeto para enviar os dados para outra Activity
                //intent variavel =new intent(origem,Destino.class);
                Intent correio = new Intent(getApplicationContext(),
                        Destino.class);


                //enviar o pacote ao correio
                correio.putExtras(pacote);

                //agora o correio vai ENTREGAR o pacote no destino

                startActivity(correio);

            }
        });
    }
}