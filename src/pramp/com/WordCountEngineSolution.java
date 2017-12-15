package pramp.com;

import java.io.*;
import java.util.*;

public class WordCountEngineSolution {

  static String[][] wordCountEngine(String document) {
    if (document == null || document.isEmpty()) {
      return null;
    }

    // String tokenization - remove punctuation and splits by whitespace
    String[] tokens = document.toLowerCase().replaceAll("[^a-z0-9 ]", "").split("\\s+");

    // Construct map to store frequencies and a list to store order of appearance
    HashMap<String, Integer> wordCountDictionary = new HashMap<>();
    ArrayList<String> orderOfAppearance = new ArrayList<>();

    for (String str : tokens) {
      if (!wordCountDictionary.containsKey(str)) {
        wordCountDictionary.put(str, 1);
        orderOfAppearance.add(str);
      } else {
        wordCountDictionary.put(str, wordCountDictionary.get(str) + 1);
      }
    }

    // Build the array of queues, with size = max of frequencies used for the bucket sort
    int maxFreq = 0;
    for (Integer i : wordCountDictionary.values()) {
      maxFreq = i > maxFreq ? i : maxFreq;
    }
    ArrayDeque<String>[] bucketArray = new ArrayDeque[maxFreq + 1];

    // Adds the words in order of appearance to the buckets
    for (String s : orderOfAppearance) {
      int freqIndex = wordCountDictionary.get(s);
      if (bucketArray[freqIndex] == null) {
        bucketArray[freqIndex] = new ArrayDeque<String>();
      }
      bucketArray[freqIndex].addFirst(s);
    }

    // Finally generate the return string;
    String[][] frequencies = new String[wordCountDictionary.size()][2];

    int frequenciesIndex = 0;
    for (int i = maxFreq; i >= 0; i--) {
      while (bucketArray[i] != null && !bucketArray[i].isEmpty()) {
        frequencies[frequenciesIndex][0] = bucketArray[i].removeLast();
        frequencies[frequenciesIndex][1] = wordCountDictionary.get(frequencies[frequenciesIndex][0]).toString();
        frequenciesIndex++;
      }
    }
    return frequencies;
  }

  public static void main(String[] args) {
    String document = "Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. ";

    String[][] freq = wordCountEngine(document);

    System.out.print("[ ");
    for (int row = 0; row < freq.length; row++) {
      System.out.print("[" + freq[row][0] + "," + freq[row][1] + "]");
      if (row < freq.length - 1) {
        System.out.print(",");
      }
    }
    System.out.println(" ]");
  }
}