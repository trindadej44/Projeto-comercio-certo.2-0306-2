package com.example.projeto_comercio_certo2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Armazem extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armazem);

        Button btnAddProduct = findViewById(R.id.btnAddProduct);
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etProductName = findViewById(R.id.etProductName);
                EditText etProductDescription = findViewById(R.id.etProductDescription);
                EditText etProductPrice = findViewById(R.id.etProductPrice);

                String name = etProductName.getText().toString();
                String description = etProductDescription.getText().toString();
                double price = Double.parseDouble(etProductPrice.getText().toString());

                // Adiciona o novo produto à lista
                adicionarProduto(new Product(name, description, price));

                // Limpa os campos de entrada após a adição do produto
                etProductName.setText("");
                etProductDescription.setText("");
                etProductPrice.setText("");
            }
        });

        ImageButton backButton = findViewById(R.id.btnBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Volta para a página anterior
            }
        });

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Carrega a lista de produtos
        productList = ProductManager.loadProductList(this);
        if (productList == null) {
            productList = new ArrayList<>(); // Se a lista estiver vazia, inicialize uma nova lista
        }

        // Adaptador para exibir os produtos na RecyclerView
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Salva a lista de produtos ao pausar a atividade
        ProductManager.saveProductList(this, productList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Carrega a lista de produtos ao retomar a atividade
        productList = ProductManager.loadProductList(this);
        if (productList == null) {
            productList = new ArrayList<>(); // Se a lista estiver vazia, inicialize uma nova lista
        }
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);
    }

    // Método para adicionar um novo produto
    public void adicionarProduto(Product produto) {
        productList.add(produto);
        adapter.notifyDataSetChanged(); // Notificar o RecyclerView que os dados foram alterados
    }

    // Método para remover um produto
    public void removerProduto(int position) {
        productList.remove(position);
        adapter.notifyDataSetChanged(); // Notificar o RecyclerView que os dados foram alterados
    }

    // Método para alterar o nome de um produto
    public void alterarNomeProduto(int position, String novoNome) {
        productList.get(position).setName(novoNome);
        adapter.notifyDataSetChanged(); // Notificar o RecyclerView que os dados foram alterados
    }
}
