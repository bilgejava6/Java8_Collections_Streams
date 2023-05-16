package com.muhammet;

import java.util.ArrayList;
import java.util.List;

public class Streams_Ornek {

    public static void main(String[] args) {

        List<Urun> urunler = new ArrayList<>();
        urunler.add(Urun.builder().id(1L).ad("Laptop").fiyat(1000.0).build());
        urunler.add(Urun.builder().id(2L).ad("Mouse").fiyat(20.0).build());
        urunler.add(Urun.builder().id(3L).ad("Monitor").fiyat(200.0).build());
        urunler.add(Urun.builder().id(4L).ad("Klavye").fiyat(50.0).build());
        urunler.add(Urun.builder().id(5L).ad("Kulaklık").fiyat(100.0).build());

        for (int i=0; i<urunler.size(); i++) {
            System.out.println(urunler.get(i).getAd());
        }
        System.out.println("**********");

        for (Urun urun : urunler) {
            System.out.println(urun.getAd());
        }
        System.out.println("**********");

        urunler.forEach(urun->{
            System.out.println(urun.getAd());
        });
        System.out.println("id si 3 ten büyük ürün listesi");
        urunler.stream().filter(urun-> urun.getId()>3).forEach(urun->{
            System.out.println(urun.getAd());
        });

    }
}
