public class StringTest {
    public static void main(String args[]) {
        String st = "this is my home";
        String st1 = st.substring(0, 3);
        System.out.println(st1);

        String[] array = st.split("");
        for (String s : array)
            System.out.println(s);

    }
}
