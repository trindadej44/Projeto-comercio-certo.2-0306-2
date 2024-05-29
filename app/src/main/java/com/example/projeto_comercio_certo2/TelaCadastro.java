package com.example.projeto_comercio_certo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TelaCadastro extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private Button buttonRegister;

    private Button buttonVoltarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        buttonVoltarLogin = findViewById(R.id.buttonVoltarLogin);


        // Inicialização dos componentes da interface
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonVoltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela de cadastro quando o botão for clicado
                startActivity(new Intent(TelaCadastro.this, LoginActivity.class));
            }
        });

        // Configuração do listener do botão de cadastro
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Captura dos dados inseridos pelo usuário
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Verifica se os campos não estão vazios
                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(TelaCadastro.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Aqui você pode implementar a lógica para salvar os dados localmente
                    // Por exemplo, salvar em SharedPreferences ou em um arquivo local

                    // Salvando os dados em um arquivo de texto local (apenas como exemplo)
                    saveDataToFile(name, email, phone, password);

                    // Mensagem de sucesso
                    Toast.makeText(TelaCadastro.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                    // Limpando os campos após o cadastro
                    editTextName.setText("");
                    editTextEmail.setText("");
                    editTextPhone.setText("");
                    editTextPassword.setText("");
                }
            }
        });
    }

    // Método para salvar os dados em um arquivo de texto
    private void saveDataToFile(String name, String email, String phone, String password) {
        try {
            // Criando ou abrindo o arquivo de texto para escrita
            File file = new File(getFilesDir(), "user_data.txt");
            FileOutputStream fos = new FileOutputStream(file, true); // O segundo parâmetro true indica que os dados serão adicionados ao final do arquivo
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            // Escrevendo os dados no arquivo
            osw.write("Nome: " + name + "\n");
            osw.write("E-mail: " + email + "\n");
            osw.write("Telefone: " + phone + "\n");
            osw.write("Senha: " + password + "\n\n");

            // Fechando os fluxos de escrita
            osw.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao salvar os dados", Toast.LENGTH_SHORT).show();
        }
    }
}
