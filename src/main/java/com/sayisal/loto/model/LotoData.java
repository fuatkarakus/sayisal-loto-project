package com.sayisal.loto.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class LotoData {

    public String oid;

    public int hafta;

    public String cekilisTarihi;

    public String cekilisTuru;

    public String rakamlar;

    public String rakamlarNumaraSirasi;

    public boolean devretti;

    public int devirSayisi;

    public ArrayList<BilenKisiler> bilenKisiler;

    public ArrayList<BuyukIkrKazananIlIlceler> buyukIkrKazananIlIlceler;

    public int kibrisHasilati;

    public float devirTutari;

    public int kolonSayisi;

    public float kdv;

    public int toplamHasilat;

    public float hasilat;

    public float sov;

    public float ikramiyeEH;

    public float buyukIkramiye;

    public float haftayaDevredenTutar;

}
