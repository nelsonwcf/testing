package skiena.manual;

public class Problem445Solution {

  static int[] findSmallestSnipplet(int[][] words) {
    // Variable declaration
    int[][] iWords;
    int[] currentSnippet = new int[words.length];
    int[] minSnippet = new int[words.length];
    int counter = 0;
    int minDist;
    int maxElem = Integer.MIN_VALUE;
    int minElem = Integer.MAX_VALUE;

    // Array to keep the indexes of the words
    iWords = new int[words.length][words[0].length + 1];
    for (int row = 0; row < iWords.length; row++) {
      for (int col = 0; col < iWords[0].length; col++) {
        if (col == 0) {
          iWords[row][col] = 1;
        } else {
          iWords[row][col] = words[row][col - 1];
        }
      }
    }

    // Initialize currentSnippet and minSnippet with first elements
    for (int row = 0; row < words.length; row++) {
      currentSnippet[row] = words[row][0];
      minSnippet[row] = words[row][0];
    }

    for (int i = 0; i < minSnippet.length; i++) {
      minElem = Math.min(minElem, minSnippet[i]);
      maxElem = Math.max(maxElem, minSnippet[i]);
    }

    minDist = maxElem - minElem;


    while (counter < words.length) {
      int minRow = 0;
      int minElement = Integer.MAX_VALUE;
      for (int row = 0; row < words.length; row++) {
        if (iWords[row][0] < iWords[0].length) {
          if (iWords[row][iWords[row][0]] < minElement) {
            minElement = iWords[row][iWords[row][0]];
            minRow = row;
          }
        }
      }

      currentSnippet[minRow] = minElement;
      iWords[minRow][0]++;
      if (iWords[minRow][0] == iWords[0].length) {
        counter++;
      }
      for (int i = 0; i < currentSnippet.length; i++) {
        minElem = Math.min(minElem, currentSnippet[i]);
        maxElem = Math.max(maxElem, currentSnippet[i]);
      }
      if (maxElem - minElem < minDist) {
        minDist = maxElem - minElem;
        minSnippet = currentSnippet.clone();
      }
    }

    return minSnippet;
  }

  public static void main(String[] args) {
    int[][] words = {{1,2},{3,4}};
    for (int i : findSmallestSnipplet(words)) {
      System.out.print(i + " ");
    }
  }
}