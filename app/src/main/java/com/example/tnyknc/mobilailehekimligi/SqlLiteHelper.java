package com.example.tnyknc.mobilailehekimligi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SqlLiteHelper extends SQLiteOpenHelper {
    private static final int database_VERSION = 1;
    private static final String database_NAME = "DoktorDB.db";
    private static final String table_DOKTOR = "DOKTOR";
    private static final String admin_ID = "id";
    private static final String admin_KullaniciAdi = "KullaniciAdi";
    private static final String admin_Sifre = "Sifre";
    private static final String CREATE_ADMIN_TABLE = "CREATE TABLE "
            + table_DOKTOR + " ("
            + admin_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + admin_KullaniciAdi + " TEXT, "
            + admin_Sifre + " TEXT ) ";

    public SqlLiteHelper(@Nullable Context context) {
        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ADMIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_DOKTOR);
        this.onCreate(db);
    }

    public void DoktorEkle(Doktor doktor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues degerler = new ContentValues();
        degerler.put(admin_KullaniciAdi, doktor.getKullaniciAdi());
        degerler.put(admin_Sifre, doktor.getSifre());
        db.insert(table_DOKTOR, null, degerler);
        db.close();
    }

    public List<Doktor> DoktorlariGetir() {
        List<Doktor> Doktorlar = new ArrayList<>();
        String query = "SELECT * FROM " + table_DOKTOR;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Doktor doktor = null;
        if (cursor.moveToFirst()){
            do {
                doktor = new Doktor();
                doktor.setId(Integer.parseInt(cursor.getString(0)));
                doktor.setKullaniciAdi(cursor.getString(1));
                doktor.setSifre(cursor.getString(2));
                Doktorlar.add(doktor);
            }while (cursor.moveToNext());
        }
        return Doktorlar;
    }
}
