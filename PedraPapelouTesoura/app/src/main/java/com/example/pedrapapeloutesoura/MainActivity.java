package com.example.pedrapapeloutesoura;

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
    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }
    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }
    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }
    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);//0, 1, 2
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "Pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if( //Computador Ganha
                (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel") ||
                        (opcaoApp == "Papel" && opcaoSelecionada == "Pedra") ||
                                (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura")
        ) {
            textoResultado.setText("Você perdeu!");
            System.out.println("Você perdeu!");
        }else if( //Usuário Ganha
                (opcaoSelecionada == "Tesoura" && opcaoApp == "Papel") ||
                        (opcaoSelecionada == "Papel" && opcaoApp == "Pedra") ||
                                (opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura")
        ) {
            textoResultado.setText("Você Ganhou!");
            System.out.println("Você ganhou!");
        } else { //Empate
            textoResultado.setText("Empate!");
            System.out.println("Empate!");
        }

        //System.out.println("Escolha App: " + opcaoApp);

    }
}