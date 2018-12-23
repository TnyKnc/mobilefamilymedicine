package com.example.tnyknc.mobilailehekimligi;

public class Doktor {
    int id;
    String KullaniciAdi;
    String Sifre;

    public Doktor() {
    }

    public Doktor(String kullaniciAdi, String sifre) {
        KullaniciAdi = kullaniciAdi;

        Sifre = sifre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return KullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        KullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }
}
