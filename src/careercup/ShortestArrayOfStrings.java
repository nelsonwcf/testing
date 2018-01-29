package careercup;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestArrayOfStrings {
  static ArrayList<String> getShortedArray(String[] words, String[] keywords) {
    if (words == null || keywords == null || words.length == 0 || keywords.length == 0 || keywords.length > words.length) {
      return new ArrayList<>();
    }

    // create a hashMap of string and a hashMap counter to avoid traversing it all the time
    HashMap<String, Integer> freqMap = new HashMap<>();
    int found = 0;

    // initialize the hashMap with the keywords
    for (String s : keywords) {
      freqMap.put(s, 0);
    }

    // frontRunner and backRunner are the iterators the create the sliding windows
    // minFrontRunner and minBackRunner saves the positions of the frontRunner
    // and backRunner that makes the smallest size
    int backRunner = 0;
    int frontRunner = 0;
    int minFrontRunner = 0;
    int minBackRunner = 0;
    int size = Integer.MAX_VALUE;

    // iterate through words array until the one subset that satisfies is found
    while (frontRunner < words.length) {
      String currentWord = words[frontRunner];
      if (freqMap.containsKey(currentWord)) {
        if (freqMap.get(currentWord) == 0) {
          found++;
        }
        freqMap.put(currentWord, freqMap.get(currentWord) + 1);
      }

      // check if the the current subset by iterating the backRunner
      // until is reaches a required character that is unique in the subset
      if (found == keywords.length) {
        String backWord = words[backRunner];
        while (!freqMap.containsKey(backWord) || freqMap.get(backWord) > 1) {
          if (freqMap.containsKey(backWord)) {
            freqMap.put(backWord, freqMap.get(backWord) - 1);
          }
          backRunner++;
          backWord = words[backRunner];
        }

        // after finding this new subset, checks if it is smaller than the
        // the current subset. if so, replaces it.
        if (frontRunner - backRunner + 1 < size) {
          size = frontRunner - backRunner + 1;
          minBackRunner = backRunner;
          minFrontRunner = frontRunner;
        }
      }
      // increment frontRunner until it finished the words array
      frontRunner++;
    }

    // if no subset was found by the end of the words array, return empty subset
    if (found < keywords.length) {
      return new ArrayList<>();
    }

    // if found, create a list and insert the subarray in it and returns
    ArrayList<String> result = new ArrayList<>();
    for (int i = minBackRunner; i <= minFrontRunner; i++) {
      result.add(words[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    String[] words = {"a", "b", "b", "c", "b", "a"};
    String[] keywords = {"a", "b", "c"};

    System.out.println(getShortedArray(words, keywords));
  }

}