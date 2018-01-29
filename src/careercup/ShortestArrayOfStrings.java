package careercup;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestArrayOfStrings {
  static ArrayList<String> getShortedArray(String[] words, String[] keywords) {
    if (words == null || keywords == null || words.length == 0 || keywords.length == 0 || keywords.length > words.length) {
      return new ArrayList<String>();
    }

    // create a hashMap of string and a hashMap counter to avoid traversing it all the time
    HashMap<String, Integer> freqMap = new HashMap<>();
    int freqCounter = 0;

    // initialize the hashMap with the keywords
    for (String s : keywords) {
      freqMap.put(s, 0);
    }

    // create two iterators
    int backRunner = 0;
    int frontRunner = 0;
    int minRunner = 0;
    int maxRunner = words.length;

    // move the front iterator adding the strings to the HashMap
    while (frontRunner < words.length) {
      String currentWord = words[frontRunner];
      if (freqMap.containsKey(currentWord)) {
        if (freqMap.get(currentWord) == 0) {
          freqCounter++;
        }
      }

      if (freqCounter == keywords.length) {
        while (!freqMap.containsKey(words[backRunner]) || freqMap.get(words[backRunner]) != 1) {
          String backWord = words[backRunner];
          if (freqMap.containsKey(backWord)) {
            freqMap.put(backWord, freqMap.get(backWord) - 1);
          }
          backRunner++;
        }
        if (maxRunner - minRunner > frontRunner - backRunner) {
          maxRunner = frontRunner;
          minRunner = backRunner;
        }
      }
      frontRunner++;
    }

    if (freqCounter < keywords.length) {
      return new ArrayList<String>();
    }

    ArrayList<String> al = new ArrayList<>();
    for (int i = minRunner; i <= maxRunner; i++) {
      al.add(words[i]);
    }

    return al;
  }

  public static void main(String[] args) {
    String[] words = {"a","b","b","b","b","c","c"};
    String[] keywords = {"a","b"};

    System.out.println(getShortedArray(words, keywords));
  }

}