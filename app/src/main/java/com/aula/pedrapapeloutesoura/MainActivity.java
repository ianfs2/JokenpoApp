package com.aula.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imgResultado = findViewById(R.id.imgResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);

        int numero = new Random().nextInt(3);
        String [] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes [ numero ];

        switch ( escolhaApp ){
            case "pedra" :
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){
            textoResultado.setText("Você perdeu! :(");
        }else if (
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ){
            textoResultado.setText("Você ganhou! ;)");
        }else {
            textoResultado.setText("Empatamos!");
        }

        System.out.println( "item clicado: " + escolhaApp );

    }

}