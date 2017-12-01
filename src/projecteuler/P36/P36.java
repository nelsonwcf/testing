package projecteuler.P36;

public class P36 {
    static boolean palb10(int n) {
        String s = Integer.toString(n);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    static boolean palb2(int n) {
        String s = Integer.toBinaryString(n);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long sum = 0;

        for (int i = 1; i < 1000000; i++)
            if (palb10(i) && palb2(i))
                sum += (long) i;

        System.out.println(sum);
    }
}
