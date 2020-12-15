package com.example.post8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText username,password;
    private Button btnlogin,btnreset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.id);
        password = findViewById(R.id.pass);
        btnlogin = findViewById(R.id.login);
        btnreset = findViewById(R.id.reset);

    }

    public void onClick(View view){
        if (view.getId() == R.id.login){
            String ambilUsername = username.getText().toString().trim();
            String ambilPassword = password.getText().toString().trim();

            if (ambilUsername.equals("admin") && ambilPassword.equals("admin")){
                Toast.makeText(this,"Login Berhasil", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Username atau Password Salah", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId() == R.id.reset){
            String ambilUsername = username.getText().toString().trim();
            String ambilPassword = password.getText().toString().trim();

            if (ambilUsername.isEmpty() && ambilPassword.isEmpty()){
                Toast.makeText(this,"Sudah kosong!", Toast.LENGTH_SHORT).show();
            }else{
                username.setText("");
                password.setText("");
            }
        }
    }
}