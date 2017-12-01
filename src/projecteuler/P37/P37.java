package projecteuler.P37;

public class P37 {

    static boolean isTruncatablePrime(long n) {
        String s = Long.toString(n);
        int len = s.length(), i = 0;
        String rightTruncated, leftTruncated;

        while (i < len) {
            rightTruncated = s.substring(0, len - i);
            leftTruncated = s.substring(i, len);
            if (!(isPrime(Integer.parseInt(rightTruncated)) && isPrime(Integer.parseInt(leftTruncated))))
                return false;
            i++;
        }
        return true;
    }

    static boolean isPrime(long n) {
        if (n == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(9));
        int count = 0, sum = 0, i = 10;
        while (count < 11) {
            if (isTruncatablePrime(i)) {
                count++;
                sum += i;
            }
            i++;
        }
        System.out.println(sum);
    }

}
