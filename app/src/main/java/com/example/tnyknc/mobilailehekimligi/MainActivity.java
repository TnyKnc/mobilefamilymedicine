package com.example.tnyknc.mobilailehekimligi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MainTiklandi(View v){
        if(v.getId()==R.id.btnGecmisTanilar){
            //Geçmiş Tanılar Ekranına Geçilecek.
            Intent intent = new Intent(getApplicationContext(),GecmisTanilar.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.btnTaniKoyma){
            Intent intent = new Intent(getApplicationContext(),TaniKoyma.class);
            startActivity(intent);

        }

    }

}
