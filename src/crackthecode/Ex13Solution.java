package crackthecode;

public class Ex13Solution {
    static void URLify(char[] url, int length) {
        if (url == null)
            return;
        else {
            // find how many spaces are there
            // O(n) complexity
            int spaces = 0;
            for (int i = 0; i < length; i++)
                if (url[i] == ' ')
                    spaces++;

            // fill the characters in the string backwards
            // since we know the final size, the remaining
            // space will be filled with blank spaces
            // which could be easily trimmed
            int i = length - 1;
            int j = length + 2 * spaces - 1;
            while (i >= 0) {
                if (url[i] != ' ') {
                    url[j--] = url[i--];
                } else {
                    url[j--] = '0';
                    url[j--] = '2';
                    url[j--] = '%';
                    i--;
                }
            }
        }
    }

    public static void main(String args[]) {
        char[] arr = "Tsvetelina Hristova                  ".toCharArray();
        URLify(arr, 19);
        for (char cc : arr)
            System.out.print(cc);
        System.out.println();
    }
}
