package com.example.demo.test;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<Integer>();
    int[] arr = new int[Integer.valueOf(scanner.next())];
    int index = 0;
    while (scanner.hasNext()) {
      //list.add(Integer.valueOf(scanner.next()));
      arr[index++] = Integer.valueOf(scanner.next());
    }


    scanner.close();
    //int[] arr = list.stream().mapToInt(i -> i).toArray();
    //System.out.println(df.format(Arrays.stream(arr).average().getAsDouble()));
    System.out.println(String.format("%.1f", Arrays.stream(arr).average().getAsDouble()));
    IntStream sortedArray = Arrays.stream(arr).sorted();
    double rt = 0.0;
    if (arr.length % 2 == 0) {
      rt = sortedArray.skip(arr.length / 2 - 1).limit(2).average().getAsDouble();
    } else {
      rt = sortedArray.skip(arr.length / 2).findFirst().getAsInt();
    }
    System.out.println(String.format("%.1f", rt));

    Map<Integer, Long> myMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
      .entrySet().stream().sorted(Map.Entry.comparingByKey())
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    Long v = myMap.entrySet().stream().findFirst().get().getValue();
    Integer k = myMap.entrySet().stream().findFirst().get().getKey();

    Iterator<Integer> iterator = myMap.keySet().iterator();
    while (iterator.hasNext()) {
      Integer key = iterator.next();
      if (myMap.get(key) > v) {
        k = key;
      }
    }
    System.out.println(k);
  }
}
