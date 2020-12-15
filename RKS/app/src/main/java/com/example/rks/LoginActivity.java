package com.example.rks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText idUser,passUser;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idUser = findViewById(R.id.id);
        passUser = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.login);
    }
    public void onClick(View view){
        if (view.getId() == R.id.login){
            String ambilUsername = idUser.getText().toString().trim();
            String ambilPassword = passUser.getText().toString().trim();

            if (ambilUsername.equals("admin") && ambilPassword.equals("admin")){
                Toast.makeText(this,"Login Berhasil", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Username atau Password Salah", Toast.LENGTH_SHORT).show();
            }
        }
    };
}