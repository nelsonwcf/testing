package pramp.com;

import java.util.Arrays;

public class MeetingPlannerSolution {
  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    if (slotsA == null || slotsA.length == 0 || slotsB == null || slotsB.length == 0) {
      return new int[0];
    }

    int[] schedule = new int[2];
    int iA = 0;
    int iB = 0;

    while (iA < slotsA.length && iB < slotsB.length) {
      if (slotsA[iA][1] < slotsB[iB][0]) {
        iA++;
      } else if (slotsB[iB][1] < slotsA[iA][0]) {
        iB++;
      } else {
        schedule[0] = Math.max(slotsA[iA][0], slotsB[iB][0]);
        schedule[1] = Math.min(slotsA[iA][1], slotsB[iB][1]);
        if (schedule[1] - schedule[0] >= dur) {
          schedule[1] = schedule[0] + dur;
          return schedule;
        } else {
          if (slotsA[iA][1] <= slotsB[iB][1]) {
            iA++;
          } else {
            iB++;
          }
        }
      }
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int[][] slotsA = {{10, 50}, {60, 120}, {140, 210}};
    int[][] slotsB = {{0, 15}, {60, 70}};
    int dur = 8;
    System.out.println(Arrays.toString(meetingPlanner(slotsA, slotsB, dur)));
  }
}
