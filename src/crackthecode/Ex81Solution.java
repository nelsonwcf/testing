public class Ex81Solution {
    static int countWaysV1(int n) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else
            return countWaysV1(n - 1) + countWaysV1(n - 2) + countWaysV1(n - 3);

    }

    static int countWaysV2(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        return countWaysV2Aux(n, array);
    }

    static int countWaysV2Aux(int n, int[] cache) {
        if (n < 0)
            return 0;
        else if (cache[n] > 0)
            return cache[n];
        else
            cache[n] = countWaysV2Aux(n - 1, cache) + countWaysV2Aux(n - 2, cache) + countWaysV2Aux(n - 3, cache);
        return cache[n];
    }

    public static void main(String args[]) {
        System.out.println(countWaysV2(10));

    }
}
