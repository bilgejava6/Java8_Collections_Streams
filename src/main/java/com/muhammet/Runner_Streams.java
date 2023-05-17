package com.muhammet;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner_Streams {
    public static void main(String[] args) {
        /**
         *  = işlemi bir değişkeni(Nesne) diğer bir değişkene atamaz. referansı atar.
         */
        Stream<String> bos_stream = Stream.empty(); // count = 0;
        long icerik =  bos_stream.count();
        System.out.println("bos_stream.count() = " + icerik);
        bos_stream = Stream.of("Muhammet","Ali","Veli","Deli");
        icerik = bos_stream.count()+1;
        System.out.println("bos_stream.count() = " + icerik);
        List<String> ogrenciIsimListesi = List.of("Muhammet","Ali","Veli","Deli");
        Stream<String> streamOgrenci = ogrenciIsimListesi.stream();
        streamOgrenci.forEach(System.out::println);

        /**
         * Sonsuz Stream Kullanımı
         */
        Stream<Double> rastgeleSayilar = Stream.generate(Math::random);
        // System.out.println("Random sayı ver.....: "+ rastgeleSayilar.findFirst().get());
        // rastgeleSayilar.forEach(System.out::println);
        Stream<Integer> sonsuzTamSayi = Stream.iterate(7, n -> n+3);
        // sonsuzTamSayi.limit(20).forEach(System.out::println);
        sonsuzTamSayi = Stream.iterate(10, n -> n<40, n -> n+4);
        sonsuzTamSayi.forEach(System.out::println);

        /**
         * Methodlar
         * -> count
         * -> min, max
         * -> forEach
         * -> findFirst, findAny
         */
        Stream<String> meyveler = Stream.of("Elma","Armut","Kiraz","Karpuz","Muz");
        // System.out.println("meyveler.count() = " + meyveler.count());
        Optional<String> min =  meyveler.min((s1,s2) -> s1.length() - s2.length());
        System.out.println("min = " + min.get()); // hata verebilir
        min.ifPresent(System.out::println); // hatasız çalışır, eğer değer varsa yazdırır.

        var meyveAdi = new String[] {"E","l","m","a"};
        var ad = "";
        for(String s : meyveAdi) ad += s;
        System.out.println("ad = " + ad);

        Stream<String> meyveAdi2 = Stream.of("E","l","m","a");
        String ad2 = meyveAdi2.reduce("",(s,c) -> s+c );
        System.out.println("ad2 = " + ad2);
        System.out.println(Stream.of("A","r","m","u","t").reduce("",(s,c)-> s+c));

        Stream<Integer> sayilar = Stream.of(4,5,6);
        /**
         * step1 - 1*4 = 4
         * step2 - 4*5 = 20
         * step3 - 20*6 = 120
         */
        Integer sonuc = sayilar.reduce(1,(a,b) -> a*b); // 120
        System.out.println("sonuc = " + sonuc);

        BinaryOperator<Integer> bo = (x,y) -> x*y;
        Stream<Integer> bosSayilar = Stream.empty(); // içinde değer yok
        Stream<Integer> tekSayilar = Stream.of(9);
        Stream<Integer> ciftSayilar = Stream.of(4,6,8);
        bosSayilar.reduce(bo).ifPresent(System.out::println); // no output - çıktı vermeyecek
        tekSayilar.reduce(bo).ifPresent(System.out::println); // 9
        ciftSayilar.reduce(bo).ifPresent(System.out::println); // 192

        /**
         * DİKKAT BU KISIMDAN SONRASINI LÜTFEN TEKRAR TEKRAR YAZINIZ
         */
        Stream<String> hayvanIsmi = Stream.of("k","a","p","l","u","m","b","a","g","a");
        TreeSet<String> setTreeHayvan = hayvanIsmi.collect(
                TreeSet::new,
                TreeSet::add,
                TreeSet::addAll
        );
        /**
         * ÇIKTI TAHMİNLERİ
         * -> Kaplumbg
         * ->
         */
        System.out.println("setTreeHayvan = " + setTreeHayvan);

        setTreeHayvan.descendingSet().forEach(System.out::println);

        Stream<String> isimListesi = Stream
                .of("Muhammet","Ali","Veli","Deli","Can","Deniz","Hakan","Berke",
                        "Deniz","Yağmur","Canan","Emel","Demet","Gülşen","Bahar","Busra");
        System.out.println("****** isimListesi ******");
        // isimListesi.filter(isim -> isim.startsWith("B")).forEach(System.out::println);
        // isimListesi.filter(x -> x.contains("ü")).forEach(System.out::println);
        // isimListesi.filter(x -> x.length() > 5).forEach(System.out::println);
        // musteriListesi.filter(x-> x.getYas() > 50)

        Stream<String> satisListesi = Stream
                .of("Elma","Armut","Muz","Kiraz","Elma","Karpuz","Muz","Elma",
                        "Armut","Muz","Kiraz","Elma","Karpuz","Muz");
        satisListesi.distinct().forEach(System.out::println);

        /**
         *
         *
         *
             public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
             {
             Map<Object, Boolean> map = new ConcurrentHashMap<>();
             return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
             }
         *
         */
        satisListesi = Stream
                .of("Elma","Armut","Muz","Kiraz","Karpuz");
        satisListesi.map(String::length).forEach(System.out::println);
        /**
         * K,V -> Map<Integer,List<String>> => 4, [Elma] <> 5,[Armut,Kiraz] <> 3,[Muz] <> 6,[Karpuz]
         */
        System.out.println("****** İSİMLERİ SIRALAMA ******");
        Stream<String> isimler = Stream.of("Muhammet","Ali","Veli","Deli","Can","Deniz","Hakan","Berke",
                "Deniz","Yağmur","Canan","Emel","Demet","Gülşen","Bahar","Busra");
        // isimler.sorted().forEach(System.out::println);
        isimler.sorted(Comparator.reverseOrder()).forEach(System.out::println);
        List<String> isimlerListesi = new ArrayList<>();
        isimlerListesi.add("Muhammet");
        isimlerListesi.add("Ali");
        isimlerListesi.add("Veli");
        isimlerListesi.stream().sorted().forEach(System.out::println);

        /**
         * Tür Dönüşümlerini Collecitons ler arası yapalım.
         */
        System.out.println("****** TÜR DÖNÜSÜMLERİ ******");
        Stream<String> listIsim = Stream.of("Muhammet","Ali","Canan","Gulsen");
        Map<String,Integer> mapIsim = listIsim.collect(
                Collectors.toMap(
                        isim-> isim.toUpperCase(Locale.forLanguageTag("tr-TR")), isim -> isim.length()
                )
        );
        listIsim = Stream.of("Muhammet","Ali","Canan","Gulsen");
        Map<String,Integer> mapIsim2 = listIsim.collect(
                Collectors.toMap(
                        String::toUpperCase, String::length
                )
        );
        System.out.println("mapIsim = " + mapIsim);
        System.out.println("mapIsim2 = " + mapIsim2);
        /**
         * K,V -> Integer, List<String> -> 3, [Ali,Can,Gul]
         *                                8          3     5       6        5      5       3      5      5      5        3
         */
        listIsim = Stream.of("Muhammet","Ali","Canan","Gulsen","Tekin","Murat","Can","Hakki","Hakan","Demet","Gul");
        Map<Integer,List<String>> mapListLength = listIsim.collect(
                Collectors.groupingBy(
                        String::length
                )
        );
        System.out.println(mapListLength);

        /**
         *
         */
        listIsim = Stream.of("Muhammet","Ali","Canan","Gulsen","Tekin","Murat","Can","Hakki","Hakan","Demet","Gul");
        TreeMap<Integer,List<String>> treeMApList = listIsim.collect(
            Collectors.groupingBy(
                    String::length,
                    TreeMap::new,
                    Collectors.toList()
            )
        );
        System.out.println(treeMApList);

    }   // Main Method Sonu
}// Class Sonu
