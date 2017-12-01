import java.util.HashMap;

public class MemoFibonacciSolution {
    static HashMap<Integer, Integer> hs = new HashMap<>();

    static int fibonacci(int term) {
        if (hs.containsKey(term))
            return hs.get(term);

        int result;

        if (term == 1 || term == 2)
            return 1;
        else
            result = fibonacci(term - 1) + fibonacci(term - 2);
        hs.put(term, result);
        return result;
    }

    public static void main(String args[]) {
        System.out.println(fibonacci(100));
    }
}
