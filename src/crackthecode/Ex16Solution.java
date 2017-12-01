package crackthecode;

public class Ex16Solution {
    static String stringCompressor(String str) {
        if (str.length() <= 2)
            return str;

        StringBuilder sb = new StringBuilder();

        char c = str.charAt(0);
        int counter = 1;

        for (int i = 1; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                counter++;
            } else {
                sb.append(str.charAt(i - 1));
                sb.append(counter);
                counter = 1;
                c = str.charAt(i);
            }
        }

        sb.append(c);
        sb.append(counter);

        return sb.toString().length() <= str.length() ? sb.toString() : str;
    }

    public static void main(String args[]) {
        String str = "aaaccXXXcc";
        System.out.println(stringCompressor(str));
    }
}