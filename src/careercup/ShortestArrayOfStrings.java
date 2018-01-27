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
    for (frontRunner = 0; frontRunner < words.length; frontRunner++) {
      String frontWord = words[frontRunner];
      if (freqMap.containsKey(frontWord)) {
        int val = freqMap.get(frontWord);
        if (val == 0) {
          freqCounter++;
        }
        freqMap.put(frontWord, val + 1);
      }


        frontWord = words[backRunner];
        int val = freqMap.get(frontWord);
        while (val > 1 && freqCounter == words.length) {
          backRunner++;
          freqMap.put(frontWord, val - 1);
          frontWord = words[backRunner];
          val = freqMap.get(frontWord);
        }
      }
    }

    // if the frequency would get to 0, than instead move the front runner again

    // to that until the front runner reached end or the every word counts to one
  }
}
