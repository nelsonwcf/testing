public class Ex15Solution {

    // Time complexity of this function is O(n+m)
    // Space complexity is O(1)
    static boolean oneAway(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        int distDelta = (Math.abs(str1.length() - str2.length()));
        boolean foundDif = false;

        if (distDelta > 1)
            return false;

        String lstr = str1.length() >= str2.length() ? str1 : str2;
        String sstr = str1.length() >= str2.length() ? str2 : str1;

        int l = 0, s = 0;

        // If arrays have the same size
        if (distDelta == 0) {
            while (l < lstr.length() && s < sstr.length()) {
                if (lstr.charAt(l) != sstr.charAt(s))
                    if (foundDif) {
                        return false;
                    } else {
                        foundDif = true;
                    }
                l++;
                s++;
            }
            // Arrays of different sizes
        } else {
            while (l < lstr.length() && s < sstr.length()) {
                if (lstr.charAt(l) != sstr.charAt(s))
                    if (foundDif) {
                        return false;
                    } else {
                        foundDif = true;
                    }
                else
                    s++;
                l++;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String str1 = "pale";
        String str2 = "bae";

        System.out.println(oneAway(str1, str2));
    }
}
