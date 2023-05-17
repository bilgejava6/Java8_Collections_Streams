package com.muhammet.ornek;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DataImpl {
    public static List<Bolum> bolumList = Arrays.asList(
            Bolum.builder().id(UUID.randomUUID()).ad("Bilgi İşlem").build(),
            Bolum.builder().id(UUID.randomUUID()).ad("Muhasebe").build(),
            Bolum.builder().id(UUID.randomUUID()).ad("İnsan Kaynakları").build()
    );
    public static List<Calisan> calisanList = Arrays.asList(
            Calisan.builder().ad("Muhammet").adres("İstanbul").telefon("1234567890").bolum(bolumList.get(0)).build(),
            Calisan.builder().ad("Ahmet").adres("Ankara").telefon("1234567890").bolum(bolumList.get(1)).build(),
            Calisan.builder().ad("Mehmet").adres("İzmir").telefon("1234567890").bolum(bolumList.get(2)).build(),
            Calisan.builder().ad("Ayşe").adres("Bursa").telefon("1234567890").bolum(bolumList.get(0)).build(),
            Calisan.builder().ad("Fatma").adres("Antalya").telefon("1234567890").bolum(bolumList.get(1)).build(),
            Calisan.builder().ad("Derya").adres("Ankara").telefon("1234567890").bolum(bolumList.get(1)).build(),
            Calisan.builder().ad("Deniz").adres("Bursa").telefon("1234567890").bolum(bolumList.get(1)).build()
            );
}
