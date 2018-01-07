package pramp.com;

public class BusiestTimeSolution {

  static int findBusiestPeriod(int[][] data) {
    if (data == null || data.length == 0) {
      return 0;
    }

    int[][] visitorsAccumulator = new int[data.length][2];
    visitorsAccumulator[0][0] = data[0][0];
    visitorsAccumulator[0][1] = data[0][2] == 1 ? data[0][1] : -data[0][1];

    int[] maxVisitors = new int[2];
    maxVisitors[0] = visitorsAccumulator[0][0];
    maxVisitors[1] = visitorsAccumulator[0][1];

    for (int i = 1; i < data.length; i++) {
      visitorsAccumulator[i][1] += data[i][2] == 1 ? data[i][1] : -data[i][1];
      visitorsAccumulator[i][0] = data[i][0];
      if (i < data.length - 1 && data[i + 1][0] > data[i][0]) {
        if (maxVisitors[1] < visitorsAccumulator[i][1]) {
          maxVisitors[1] = visitorsAccumulator[i][1];
          maxVisitors[0] = visitorsAccumulator[i][0];
        }
      }
    }

    return maxVisitors[0];
  }

  public static void main(String[] args) {
    int[][] data = {
        {1487799425,14,1},  // 14
        {1487799425,2,0},   // 12
        {1487800378,10,1},  // 22
        {1487801478,18,0},  // 4
        {1487801478,18,1},  // 22
        {1487901013,1,0},   // 21
        {1487901211,7,1},   // 28
        {1487901211,7,0}    // 21
    };
    System.out.println(findBusiestPeriod(data));


  }
}
