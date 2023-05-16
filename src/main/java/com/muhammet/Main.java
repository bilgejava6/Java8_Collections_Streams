package com.muhammet;

import java.util.*;

public class Main {
    private static List<String> stringList = new ArrayList<>();
    private static TreeSet<String> stringTreeSet = new TreeSet<>();
    private static Map<String,String> stringStringMap = new HashMap<>();
    private static TreeMap<String,String> stringTreeMap = new TreeMap<>();

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            stringList.add("String" + i);
        }
        Long stringListEnd = System.currentTimeMillis();
        System.out.println("String List Time: " + (stringListEnd - start) + " ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            stringTreeSet.add("String" + i);
        }
        Long stringTreeSetEnd = System.currentTimeMillis();
        System.out.println("String TreeSet Time: " + (stringTreeSetEnd - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            stringStringMap.put("String" + i, "String" + i);
        }
        Long stringStringMapEnd = System.currentTimeMillis();
        System.out.println("String String Map Time: " + (stringStringMapEnd - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            stringTreeMap.put("String" + i, "String" + i);
        }
        Long stringTreeMapEnd = System.currentTimeMillis();
        System.out.println("String TreeMap Time: " + (stringTreeMapEnd - start) + " ms");

        start = System.currentTimeMillis();
        Optional<String> sonuc = stringList.stream().filter(x-> x.equals("59985169")).findFirst();
        stringListEnd = System.currentTimeMillis();
        System.out.println("String List Search Time: " + (stringListEnd - start) + " ms");

        start = System.currentTimeMillis();
        sonuc = stringTreeSet.stream().filter(x-> x.equals("59985169")).findFirst();
        stringTreeSetEnd = System.currentTimeMillis();
        System.out.println("String TreeSet Search Time: " + (stringTreeSetEnd - start) + " ms");

        start = System.nanoTime();
        String mapsonuc = stringStringMap.get("59985169");
        stringStringMapEnd = System.nanoTime();
        System.out.println("String String Map Search Time: " + (stringStringMapEnd - start) + " ns");

        start = System.nanoTime();
        String treesonuc = stringTreeMap.get("59985169");
        stringTreeMapEnd = System.nanoTime();
        System.out.println("String TreeMap Search Time: " + (stringTreeMapEnd - start) + " ns");
    }
}