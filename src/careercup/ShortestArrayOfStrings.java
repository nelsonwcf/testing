package careercup;

import java.util.HashMap;

public class ShortestArrayOfStrings {
  static String[] getShortedArray(String[] words, String[] keywords) {
    if (words == null || keywords == null || words.length == 0 || keywords.length == 0 || keywords.length > words.length) {
      return new String[0];
    }

    // create a hashMap of string and a hashmap counter to avoid traversing it all the time
    HashMap<String, Integer> freqMap = new HashMap<>();
    int freqCounter = 0;

    // initialize the hashmap with the keywords
    for (String s : keywords) {
      freqMap.put(s, 0);
    }

    // create two iterators
    int frontRunner = 0;
    int backRunner = 0;

    // move the front iterator adding the strings to the HashMap
    while (freqCounter < keywords.length && frontRunner < words.length) {
      String currentWord = words[frontRunner];
      if (freqMap.containsKey(currentWord)) {
        if (freqMap.get(currentWord) == 0) {
          freqCounter++;
        }
        freqMap.put(currentWord, freqMap.get(currentWord + 1));
      }
      frontRunner++;
    }

    if (freqCounter < keywords.length) {
      return new String[0];
    }

    // if the frequency would get to 0, than instead move the front runner again
    String backWord = words[backRunner];
    while (freqMap.get(backWord) != 1) {
      if (freqMap.containsKey(backWord)) {
        freqMap.put(backWord, freqMap.get(backWord) - 1);
      }
    }


    // to that until the front runner reached end or the every word counts to one
    return new String[0];
  }
}