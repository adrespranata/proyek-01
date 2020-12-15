package com.example.post5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Menu menu;
    private EditText panjang,lebar,tinggi;
    private Button hitung;
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void home(){
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Menu Home Selected", Toast.LENGTH_SHORT).show();
    }

    public void praktikum() {
        setContentView(R.layout.praktikum);
        Toast.makeText(this, "Menu Praktikum Selected", Toast.LENGTH_SHORT).show();
        panjang = (EditText) findViewById(R.id.panjang);
        lebar = (EditText) findViewById(R.id.lebar);
        tinggi = (EditText) findViewById(R.id.tinggi);
        hitung = (Button) findViewById(R.id.hitung);
        hasil = (TextView) findViewById(R.id.hasil);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (panjang.length() == 0) {
                    Toast.makeText(getApplication(), "Panjang Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else if (lebar.length() == 0) {
                    Toast.makeText(getApplication(), "Lebar Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else if (tinggi.length() == 0) {
                    Toast.makeText(getApplication(), "Tinggi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    hitungvolume();
                }
            }
        });
    }

    private void hitungvolume () {
        //rumus sebenarnya V = 1/3 * L_alas * t
        //kenapa ada lebar dan panjang? karena untuk mencari luas alas
        //pada limas ini luas alasnya berbentuk persegi panjang
        double p = Double.parseDouble(panjang.getText().toString());
        double l = Double.parseDouble(lebar.getText().toString());
        double t = Double.parseDouble(tinggi.getText().toString());
        double rumus = (p * l) * t / 3;
        hasil.setText("Volumenya adalah " + rumus);
    }

    public void about(){
        Toast.makeText(this, "Menu About Selected", Toast.LENGTH_SHORT).show();
    }

    public void biodata(){
        setContentView(R.layout.biodata);
        Toast.makeText(this,"Menu Biodata Selected", Toast.LENGTH_LONG).show();
    }
    public void favorite(){
        setContentView(R.layout.favorite);
        Toast.makeText(this,"Menu Favorite Selected", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.home:
                home();
                return true;
            case R.id.praktikum:
                praktikum();
                return true;

            case R.id.about:
                about();
                return true;

            case R.id.biodata:
                biodata();
                return true;

            case R.id.favorite:
                favorite();
                return true;

            default:
                return super.onOptionsItemSelected(item);
            }
    }

}
