package skiena.manual;

public class Problem445Solution {

  static int[] findSmallestSnipplet(int[][] words) {
    if (words == null || words.length == 0) {
      return new int[0];
    }

    // Variable declaration
    int[][] iWords;
    int[] currentSnippet = new int[words.length];
    int[] minSnippet = new int[words.length];
    int counter = 0;
    int minDist;
    int maxElem = Integer.MIN_VALUE;
    int minElem = Integer.MAX_VALUE;

    // There's space for Space optimization in the code
    // Instead of copying the argument to another longer array
    // Just save the indexes in a vertical array

    // Array to keep the indexes of the words
    iWords = new int[words.length][];
    for (int row = 0; row < iWords.length; row++) {
      iWords[row] = new int[words[row].length + 1];
      for (int col = 0; col < iWords[row].length; col++) {
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
        if (iWords[row][0] == iWords[row].length - 1) {
          counter++;
        }
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
          if (iWords[row][0] < iWords[row].length - 1) {
            if (iWords[row][iWords[row][0]] < minElement) {
              minElement = iWords[row][iWords[row][0]];
              minRow = row;
            }
          }
        }

        iWords[minRow][0]++;
        if (iWords[minRow][0] == iWords[minRow].length - 1) {
          counter++;
        }
        currentSnippet[minRow] = iWords[minRow][iWords[minRow][0]];

        minElem = Integer.MAX_VALUE;
        maxElem = Integer.MIN_VALUE;

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

    public static void main (String[]args){
      int[][] words = {};
      for (int i : findSmallestSnipplet(words)) {
        System.out.print(i + " ");
      }
    }
  }