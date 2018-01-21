package pramp.com;

import java.util.ArrayList;
import java.util.HashMap;

public class WordCountEngineSolution {
  // runtime complexity: O(n), space complexity: O(n)
  static String[][] wordCountEngine(String document) {
    if (document == null || document.length() == 0) {
      return new String[0][0];
    }

    // strip punctuation
    String[] tokens = document.trim().toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");

    // create data structure to capture frequency (wordCount)
    // and order of appearance (wordList)
    HashMap<String, Integer> wordCount = new HashMap<>();
    ArrayList<String> wordList = new ArrayList<>();

    // holds greatest frequency found
    int maxFreq = 1;

    // populate data structure
    for (String s : tokens) {
      if (!wordCount.containsKey(s)) {
        wordCount.put(s, 1);
        wordList.add(s);
      } else {
        int n = wordCount.get(s);
        wordCount.put(s, n + 1);
        if (maxFreq < n + 1) {
          maxFreq = n + 1;
        }
      }
    }

    // buckets of frequencies; strings buckets ordered by order of appearance
    @SuppressWarnings("unchecked")
    ArrayList<String>[] bucketArray = new ArrayList[maxFreq + 1];

    // populate bucket array
    for (String s : wordList) { // runtime: O(n)
      int index = wordCount.get(s);
      if (bucketArray[index] == null) {
        bucketArray[index] = new ArrayList<String>();
      }
      bucketArray[index].add(s);
    }

    // array to return
    String[][] results = new String[wordList.size()][2];

    int j = maxFreq;
    int i = 0;
    while (i < results.length) {
      // iterate through bucketArray populating results
      while (bucketArray[j] != null && bucketArray[j].size() > 0) {
        results[i][0] = bucketArray[j].remove(0);
        results[i][1] = Integer.toString(j);
        i++;
      }
      j--;
    }

    return results;
  }

  public static void main(String[] args) {
    String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
    String[][] res = wordCountEngine(document);
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }
  }
}