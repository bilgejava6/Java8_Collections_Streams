package com.muhammet.ornek;

import java.util.*;
import java.util.stream.Collectors;

import static com.muhammet.ornek.DataImpl.*;
public class Runner {
    public static void main(String[] args) {

        Map<String,Integer> departmanList = calisanList.stream().collect(
                Collectors.groupingBy(
                        calisan-> calisan.getBolum().ad,
                        Collectors.summingInt(calisan->1)
                )
        );
        System.out.println(departmanList);
//
//        Map<Bolum,List<Calisan>> mapList = calisanList.stream().collect(
//                Collectors.groupingBy(Calisan::getBolum)
//        );
//        calisanList.forEach(calisan -> {
//            System.out.println(calisan.getAd());
//        });

//        mapList.forEach((bolum,calisanlar)->{
//            System.out.println("Departman Adı....: "+bolum.getAd());
//            System.out.println(calisanlar.toString());
//            System.out.println("**********************");
//        });
    }

    public static void MapIleArama(int donguSayisi){
        Long start = System.currentTimeMillis();
        Map<String, List<Calisan>> mapList =
                calisanList.stream().collect(
                        Collectors.groupingBy(Calisan::getAd)
                );
        Long donusum = System.currentTimeMillis();
        System.out.println("Dönüşüm süresi MAP : "+(donusum-start));
        final String aranan = "Muhammet";
        int bulunanAdet =0;
        for(int i=0; i<donguSayisi;i++){
            if(mapList.containsKey(aranan)){
                bulunanAdet++;
            }
        }
        System.out.println("Bulunan adet: "+bulunanAdet);
        Long end = System.currentTimeMillis();
        System.out.println("Geçen süre map....: "+(end-start));
    }
    public static void HashMapIleArama(int donguSayisi){
        Long start = System.currentTimeMillis();
        HashMap<String, List<Calisan>> mapList =
                calisanList.stream().collect(
                        Collectors.groupingBy(
                                Calisan::getAd,
                                HashMap::new,
                                Collectors.toList())
                );
        Long donusum = System.currentTimeMillis();
        System.out.println("Dönüşüm süresi HASHMAP: "+(donusum-start));
        final String aranan = "Muhammet";
        int bulunanAdet =0;
        for(int i=0; i<donguSayisi;i++){
            if(mapList.containsKey(aranan)){
                bulunanAdet++;
            }
        }
        System.out.println("Bulunan adet: "+bulunanAdet);
        Long end = System.currentTimeMillis();
        System.out.println("Geçen süre Hashmap....: "+(end-start));
    }
    public static void TreeMapIleArama(int donguSayisi){
        Long start = System.currentTimeMillis();
        TreeMap<String, List<Calisan>> mapList =
                calisanList.stream().collect(
                        Collectors.groupingBy(
                                Calisan::getAd,
                                TreeMap::new,
                                Collectors.toList()
                                )
                );
        Long donusum = System.currentTimeMillis();
        System.out.println("Dönüşüm süresi TREEMAP: "+(donusum-start));
        final String aranan = "Muhammet";
        int bulunanAdet =0;
        for(int i=0; i<donguSayisi;i++){
            if(mapList.containsKey(aranan)){
                bulunanAdet++;
            }
        }
        System.out.println("Bulunan adet: "+bulunanAdet);
        Long end = System.currentTimeMillis();
        System.out.println("Geçen süre Treemap....: "+(end-start));
    }

    public static void ListIleArama(int donguSayisi){
        Long start = System.currentTimeMillis();
        final String aranan = "Muhammet";
        int bulunanAdet =0;
        for(int i=0; i<donguSayisi;i++){
            Optional<Calisan> bulunan =
                    calisanList.stream().filter(calisan -> calisan.getAd().equals(aranan)).findFirst();
            if(bulunan.isPresent()){
                bulunanAdet++;
            }
        }
        System.out.println("Bulunan adet: "+bulunanAdet);
        Long end = System.currentTimeMillis();
        System.out.println("Geçen süre list...: "+(end-start));
    }
}
