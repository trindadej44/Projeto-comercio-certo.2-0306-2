package com.example.projeto_comercio_certo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Funcionarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionarios);

        // Dentro do método onCreate da activity Funcionarios
        RecyclerView recyclerViewAllEmployees = findViewById(R.id.recyclerViewAllEmployees);
        recyclerViewAllEmployees.setLayoutManager(new LinearLayoutManager(this));

        List<Employee> allEmployeeList = new ArrayList<Employee>(); // Substitua isso com sua lista de funcionários
        // Preencha allEmployeeList com os dados dos funcionários

        AllEmployeesAdapter allEmployeesAdapter = new AllEmployeesAdapter(allEmployeeList);
        recyclerViewAllEmployees.setAdapter(allEmployeesAdapter);

        ImageButton backButton = findViewById(R.id.btnBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Volta para a página anterior
            }
        });
    }
}