package com.example.post6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private EditText alamat, nomor, nomor2, isi_pesan, isi_url,jari;
    private  Button bt1, bt2, bt3, bt4, bt5;
    private TextView luas, volume;
    String strmaps, strpesan, strnomor, strurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ins = (ImageView) findViewById(R.id.instagram);
        ImageView twit = (ImageView) findViewById(R.id.twitter);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/_arsprta/");
            }
        });

        twit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://twitter.com/adres_pranata");
            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }


    public void maps(){
        setContentView(R.layout.maps);
        Toast.makeText(this, "Menu maps selected", Toast.LENGTH_SHORT).show();

        alamat = findViewById(R.id.alamat);
        bt1 =findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmaps = alamat.getText().toString();

                Uri uri = Uri.parse("https://www.google.com/maps/search/" + strmaps);
                Intent mapsIntent = new Intent(Intent.ACTION_VIEW, uri);
                if (alamat.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Isi alamat yang dicari", Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(mapsIntent);
                }
            }
        });
    }
    public void browser(){
        setContentView(R.layout.browser);
        Toast.makeText(this, "Menu browser selected", Toast.LENGTH_SHORT).show();

        isi_url = findViewById(R.id.isi_url);
        bt2 = findViewById(R.id.bt2);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strurl = isi_url.getText().toString();

                Uri uri = Uri.parse("https://" + strurl);
                // membuat intent baru dengan ACTION_DIAL
                Intent urlIntent = new Intent(Intent.ACTION_VIEW, uri);
                if (isi_url.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Isi url tujuan", Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(urlIntent);
                }
            }
        });
    }
    public void telpon(){
        setContentView(R.layout.telepon);
        Toast.makeText(this, "Menu telpon selected", Toast.LENGTH_SHORT).show();

        nomor2 = findViewById(R.id.no2);
        bt3 = findViewById(R.id.bt3);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strnomor = nomor2.getText().toString();

                Uri uri = Uri.parse("tel:" + strnomor);
                // membuat intent baru dengan ACTION_DIAL
                Intent telSIntent = new Intent(Intent.ACTION_DIAL, uri);
                if (nomor2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Isi nomornya", Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(telSIntent);
                }
            }
        });

    }
    public void pesan(){
        setContentView(R.layout.messages);
        Toast.makeText(this, "Menu pesan selected", Toast.LENGTH_SHORT).show();

        nomor = findViewById(R.id.no_tujuan);
        isi_pesan = findViewById(R.id.isi_pesan);
        bt4 = findViewById(R.id.bt4);

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strpesan = isi_pesan.getText().toString();
                strnomor = nomor.getText().toString();

                Uri uri = Uri.parse("smsto:" + strnomor);
                // membuat intent baru dengan ACTION_SENDTO
                Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
                // menambahkan isi SMS pada field sms_body
                smsSIntent.putExtra("sms_body", strpesan);
                if (nomor.getText().toString().isEmpty() && isi_pesan.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Isi nomor dan pesannya", Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(smsSIntent);
                }
            }
        });
    }
    public void hitung(){
        setContentView(R.layout.hitung);
        Toast.makeText(this, "Menu hitung selected", Toast.LENGTH_SHORT).show();

        jari = findViewById(R.id.jari);
        luas = findViewById(R.id.hl);
        volume = findViewById(R.id.hv);
        bt5 = findViewById(R.id.bt5);

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jari.length() == 0) {
                    Toast.makeText(getApplication(), "Jari-jari Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    hitungluas();
                    hitungvolume();
                }
            }
        });
    }

    private void hitungluas(){
        double r = Double.parseDouble(jari.getText().toString());
        double rumus = 3.14*r*r;
        luas.setText("hasil " + rumus);
    }
    private void hitungvolume(){
        double r = Double.parseDouble(jari.getText().toString());
        double rumus = 3.14*r*r*r*4/3;
        volume.setText("hasil " + rumus);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.maps:
                maps();
                return true;
            case R.id.browser:
                browser();
                return true;
            case R.id.telpon:
                telpon();
                return true;
            case R.id.pesan:
                pesan();
                return true;
            case R.id.hitung:
                hitung();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}