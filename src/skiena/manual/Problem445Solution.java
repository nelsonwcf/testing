package skiena.manual;

public class Problem445Solution {
  static int[] findSmallestSnipplet(int[] word1, int[] word2, int[] word3) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int[] minSnipplet = new int[3];
    int minDist = 0;

    minSnipplet[0] = word1[0];
    minSnipplet[1] = word2[0];
    minSnipplet[2] = word3[0];
    minDist = Math.max(word1[0], Math.max(word2[0], word3[0])) - Math.min(word1[0], Math.max(word2[0], word3[0]));

    while(i1 < word1.length - 1 && i2 < word2.length - 1 && i3 < word3.length - 1) {
      if (word1[i1] <= word2[i2] && word1[i1] <= word3[i3]) {
        i1++;
      } else if (word2[i2] <= word1[i1] && word2[i2] <= word3[i3]) {
        i2++;
      } else {
        i3++;
      }
      if (Math.max(word1[i1], Math.max(word2[i2], word3[i3])) - Math.min(word1[i1], Math.max(word2[i2], word3[i3])) < minDist) {
        minDist = Math.max(word1[i1], Math.max(word2[i2], word3[i3])) - Math.min(word1[i1], Math.max(word2[i2], word3[i3]));
        minSnipplet[0] = word1[i1];
        minSnipplet[1] = word2[i2];
        minSnipplet[2] = word3[i3];
      }
    }

    return minSnipplet;
  }

  public static void main(String[] args) {
    int[] word1 = {1,4,5,11};
    int[] word2 = {4,9,10};
    int[] word3 = {1,6,9,12};
    for(int n : findSmallestSnipplet(word1, word2, word3)) {
      System.out.print(n + " ");
    }
    System.out.println();
  }
}