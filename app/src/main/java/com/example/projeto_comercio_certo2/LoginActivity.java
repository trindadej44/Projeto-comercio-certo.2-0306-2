package com.example.projeto_comercio_certo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewForgotPassword;
    private Button buttonSignUp;



    // Dados de login de exemplo (pode ser substituído por um banco de dados ou autenticação real)
    private static final String EXAMPLE_EMAIL = "user@example.com";
    private static final String EXAMPLE_PASSWORD = "password123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonSignUp = findViewById(R.id.buttonSignUp);

        // Inicialização dos componentes da interface
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword);

        // Configuração do listener do botão de login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Captura dos dados inseridos pelo usuário
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Verifica se os campos não estão vazios
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Verifica se os dados de login estão corretos
                    if (email.equals(EXAMPLE_EMAIL) && password.equals(EXAMPLE_PASSWORD)) {
                        // Autenticação bem-sucedida, redireciona para a próxima tela
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish(); // Encerra a atividade de login
                    } else {
                        // Exibe mensagem de erro para credenciais incorretas
                        Toast.makeText(LoginActivity.this, "Credenciais inválidas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Configuração do listener do link "Esqueceu sua senha"
        textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente aqui a lógica para recuperação de senha, se necessário
                Toast.makeText(LoginActivity.this, "Funcionalidade de recuperação de senha não implementada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela de cadastro quando o botão for clicado
                startActivity(new Intent(LoginActivity.this, TelaCadastro.class));
            }
        });
    }
}
