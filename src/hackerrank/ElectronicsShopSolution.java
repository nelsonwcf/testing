package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class ElectronicsShopSolution {
  static int getMoneySpent(int[] keyboards, int[] drives, int s) {
    if (keyboards == null || keyboards.length == 0 || drives == null || drives.length == 0) {
      return -1;
    }

    Arrays.sort(keyboards);
    Arrays.sort(drives);

    int k = 0;
    int d = drives.length - 1;
    int maxSum = -1;

    while (true) {
      int sum = keyboards[k] + drives[d];
      if (sum > maxSum && sum > 0 && sum <= s) {
        maxSum = sum;
      }

      if (sum == s) {
        break;
      } else if (sum > s) {
        if (d == 0) {
          break;
        } else {
          d--;
        }
      } else {
        if (k == keyboards.length - 1) {
          break;
        } else {
          k++;
        }
      }
    }
    return maxSum;
  }


//    // runtime: O(n*m), space: O(1)
//    int closestSum = -1;
//    for (int i = 0; i < keyboards.length; i++) {
//      for (int j = 0; j < drives.length; j++) {
//        int currentSum = keyboards[i] + drives[j];
//        if (s - currentSum >= 0 && s - currentSum < s - closestSum) {
//          closestSum = currentSum;
//        }
//      }
//    }
//    return closestSum;
//  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int n = in.nextInt();
    int m = in.nextInt();
    int[] keyboards = new int[n];
    for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
      keyboards[keyboards_i] = in.nextInt();
    }
    int[] drives = new int[m];
    for (int drives_i = 0; drives_i < m; drives_i++) {
      drives[drives_i] = in.nextInt();
    }
    //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
    int moneySpent = getMoneySpent(keyboards, drives, s);
    System.out.println(moneySpent);
  }
}
