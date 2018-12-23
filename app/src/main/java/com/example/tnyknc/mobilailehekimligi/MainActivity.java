package com.example.tnyknc.mobilailehekimligi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    ListView liste;
    List<Doktor> list;
    SqlLiteHelper db = new SqlLiteHelper(context);
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste = (ListView) findViewById(R.id.liste);
        db.onUpgrade(db.getWritableDatabase(), 1, 2);
        db.DoktorEkle(new Doktor("Kamil Koç", "1"));
        db.DoktorEkle(new Doktor("Yavşak Ogün", "1"));
        list = db.DoktorlariGetir();
        List<String> listDoktorAdi = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            listDoktorAdi.add(i,list.get(i).getKullaniciAdi());
        }
        mAdapter=new ArrayAdapter<String>(context,R.layout.satir_layout,R.id.listDoktorlar,listDoktorAdi);
        liste.setAdapter(mAdapter);
    }

    public void MainTiklandi(View v) {
        if (v.getId() == R.id.btnGecmisTanilar) {
            //Geçmiş Tanılar Ekranına Geçilecek.
            Intent intent = new Intent(getApplicationContext(), GecmisTanilar.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnTaniKoyma) {
            Intent intent = new Intent(getApplicationContext(), TaniKoyma.class);
            startActivity(intent);

        }

    }

}
