package com.example.tnyknc.mobilailehekimligi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Global Değişkenleri Tanımladım.
    Button btnGecmisTanilar;
    int sayi=67;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Değişken-activity_main.xml bağlantısı
        btnGecmisTanilar=findViewById(R.id.btnGecmisTanilar);

        //Click Olayı
        btnGecmisTanilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGecmisTanilar.setText("Değiştirildi :) " + sayi);
            }
        });

    }
}
