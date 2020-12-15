package com.example.pert3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nama;
    private EditText nohp;
    private EditText alamat;
    private TableLayout mp;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private TableLayout pi;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private TextView tampilnama;
    private TextView tampilnohp;
    private TextView tampilalamat;
    private TextView tampilmp;
    private TextView tampilpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama=(EditText)findViewById(R.id.isinama);
        nohp=(EditText)findViewById(R.id.isinohp);
        alamat=(EditText)findViewById(R.id.isialamat);
        mp=(TableLayout)findViewById(R.id.mp);
        rb1=(RadioButton)findViewById(R.id.rdb1);
        rb2=(RadioButton)findViewById(R.id.rdb2);
        rb3=(RadioButton)findViewById(R.id.rdb3);
        rb4=(RadioButton)findViewById(R.id.rdb4);
        pi=(TableLayout)findViewById(R.id.pi);
        cb1=(CheckBox)findViewById(R.id.dev1);
        cb2=(CheckBox)findViewById(R.id.dev2);
        cb3=(CheckBox)findViewById(R.id.dev3);
        cb4=(CheckBox)findViewById(R.id.dev4);
    }
    public void hasil(View view) {
        setContentView(R.layout.hasil);

        //Tampil data1
        tampilnama = (TextView) findViewById(R.id.tampilnama);
        tampilnama.setTextColor(Color.WHITE);
        tampilnama.setBackgroundColor(Color.TRANSPARENT);
        tampilnama.setText(nama.getText());

        tampilnohp = (TextView) findViewById(R.id.tampilnohp);
        tampilnohp.setTextColor(Color.WHITE);
        tampilnohp.setBackgroundColor(Color.TRANSPARENT);
        tampilnohp.setText(nohp.getText());

        tampilalamat = (TextView) findViewById(R.id.tampilalamat);
        tampilalamat.setTextColor(Color.WHITE);
        tampilalamat.setBackgroundColor(Color.TRANSPARENT);
        tampilalamat.setText(alamat.getText());

        tampilmp = (TextView) findViewById(R.id.tampilmp);
        tampilmp.setTextColor(Color.WHITE);
        tampilmp.setBackgroundColor(Color.TRANSPARENT);

        tampilpi = (TextView) findViewById(R.id.tampilpi);
        tampilpi.setTextColor(Color.WHITE);
        tampilpi.setBackgroundColor(Color.TRANSPARENT);

        //Tampil Data RadioButton
        if (rb1.isChecked()) {
            tampilmp.setText("Cash");
        }
        else if (rb2.isChecked()) {
            tampilmp.setText("Credit Card");
        }
        else if(rb3.isChecked()) {
            tampilmp.setText("Cicil");
        }
        else if(rb4.isChecked()) {
            tampilmp.setText("Transfer");
        }

        //Tampil Data Chechbox
        if (cb1.isChecked()){
            tampilpi.setText("Samsung A10s");
        }
        if (cb2.isChecked()){
            tampilpi.setText("Samsung A20s");
        }
        if (cb3.isChecked()){
            tampilpi.setText("Samsung A30s");
        }
        if (cb4.isChecked()){
            tampilpi.setText("Samsung A40s");
        }
    }
}