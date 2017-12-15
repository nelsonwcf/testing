package pramp.com;

import java.io.*;
import java.util.*;

public class WordCountEngineSolution {

  static String[][] wordCountEngine(String document) {
    if (document == null || document.isEmpty()) {
      return null;
    }

    // Tokenization
    String[] tokens = document.trim().toLowerCase().replaceAll("[^a-z0-9 ]","").split("\\s+");

    // Build an ordered dictionary
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

    HashMap<Integer, ArrayList<String>> reverseWordCountDictionary = new HashMap<>();

    for (String str : orderOfAppearance) {
      int counter = wordCountDictionary.get(str);
      if (!reverseWordCountDictionary.containsKey(counter)) {
        reverseWordCountDictionary.put(counter, new ArrayList<String>(Arrays.asList(str)));
      } else {
        reverseWordCountDictionary.get(counter).add(str);
      }
    }

    ArrayList<Integer> iterableFrequencies = new ArrayList<>(reverseWordCountDictionary.keySet());
    Collections.sort(iterableFrequencies);
    Collections.reverse(iterableFrequencies);

    String[][] frequencies = new String[orderOfAppearance.size()][2];

    int c = 0;
    for (int i : iterableFrequencies) {
      for (String str : reverseWordCountDictionary.get(i)) {
        frequencies[c][0] = str;
        frequencies[c][1] = Integer.toString(i);
        c++;
      }
    }

    return frequencies;
  }

  public static void main(String[] args) {
    String document = "Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. ";

    String[][] freq = wordCountEngine(document);

    for (int i = 0; i < freq[0].length; i++) {
      for (int j = 0; j < freq.length; j++) {
        System.out.print(freq[j][i] + " ");
      }
      System.out.println();
    }

  }

}