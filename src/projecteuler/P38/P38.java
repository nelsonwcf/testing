package P38;

public class P38 {
    static long contactNumber(int base, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(i * base);
        }

        if (sb.toString().length() > 9)
            return 0;
        else
            return Long.parseLong(sb.toString());
    }

    static boolean isPanDigital(long n) {
        if (n == 0)
            return false;

        String s = Long.toString(n);
        int len = s.length();

        if (len != 9)
            return false;

        int[] array = new int[9];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) < '1' || s.charAt(i) > '9')
                return false;
            else {
                int v = Character.getNumericValue(s.charAt(i));
                if (array[v - 1] > 0) {
                    return false;
                } else {
                    array[v - 1] = 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long sum = 0;

        for (int i = 1; i < 100000; i++) {
            for (int j = 2; j < 10; j++) {
                long m = contactNumber(i, j);
                if (isPanDigital(m) && sum < m)
                    sum = m;
            }
        }
        System.out.println(sum);
    }
}
