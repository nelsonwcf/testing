package pramp;

public class BusiestTimeSolution {

  static int findBusiestPeriod(int[][] data) {
    if (data == null || data.length == 0) {
      return 0;
    }

    int accum = data[0][2] == 1 ? data[0][1] : -data[0][1];
    int[] maxVis = new int[2];
    maxVis[0] = data[0][0];
    maxVis[1] = accum;

    for (int i = 1; i < data.length; i++) {
      accum += data[i][2] == 1 ? data[i][1] : -data[i][1];
      if (i == data.length - 1 || data[i][0] != data[i + 1][0]) {
        if (maxVis[1] < accum) {
          maxVis[0] = data[i][0];
          maxVis[1] = accum;
        }
      }
    }
    return maxVis[0];
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
    // System.out.println(findBusiestPeriod(data));

    int[][] data2 = {
        {1487799425,14,1}, // 14
        {1487799425,4,1}, // 18
        {1487799425,2,1}, // 20
        {1487800378,10,1}, // 30
        {1487801478,18,1}, // 48
        {1487901013,1,1}, // 49
        {1487901211,7,1},
        {1487901211,7,1}}; // 63
    System.out.println(findBusiestPeriod(data2));
  }
}
