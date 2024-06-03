package com.example.projeto_comercio_certo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referências para os botões
        Button btnVerItens = findViewById(R.id.btnVerItens);
        Button btnVerFuncionarios = findViewById(R.id.btnVerFuncionarios);
        Button btnRelatorioVendas = findViewById(R.id.btnRelatoriosVendas);
        Button btnTabelaPrecos = findViewById(R.id.btnTabelaPrecos);

        // Configurar OnClickListener para cada botão
        btnVerItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a activity VerItensActivity
                Intent intent = new Intent(MainActivity.this, Armazem.class);
                startActivity(intent);
            }
        });

        btnVerFuncionarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a activity OutraFuncaoActivity
                Intent intent = new Intent(MainActivity.this, Funcionarios.class);
                startActivity(intent);
            }
        });

        btnRelatorioVendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a activity MaisUmActivity
                Intent intent = new Intent(MainActivity.this, RelatorioVendas.class);
                startActivity(intent);
            }
        });

        btnTabelaPrecos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a activity MaisOutraFuncaoActivity
                Intent intent = new Intent(MainActivity.this, TabelaPrecos.class);
                startActivity(intent);
            }
        });
    }
}