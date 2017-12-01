package projecteuler.P39;

// Ugly brute force -> takes about 2 min -> Complexity O(n^3)
public class P39 {

    static int numberOfSolutions(int p) {
        if (p < 12)
            return 0;

        int solutions = 0;

        for (int i = p; i >= 1; i--) {
            for (int j = p - i; j >= 1; j--) {
                for (int k = p - i - j; k >= 1; k--) {
                    if (Math.pow(i, 2) == Math.pow(j, 2) + Math.pow(k, 2) && i + j + k == p) {
                        solutions++;
                    }
                }
            }
        }
        return solutions;
    }

    public static void main(String[] args) {
        int total = 0;
        int p = 0;

        for (int i = 12; i <= 1000; i++) {
            int v = numberOfSolutions(i);
            if (v > total) {
                total = v;
                p = i;
            }
        }
        System.out.println(p);
    }
}
