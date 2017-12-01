import java.util.*;

public class Ex84Solution {
//    // My solution.
//    // The problem is that it has n! complexity, which is hideous
//    static HashSet<HashSet<Integer>> allSubsets(HashSet<Integer> fullset) {
//        if (fullset == null || fullset.isEmpty())
//            return null;
//
//        HashSet<HashSet<Integer>> array = new HashSet<>();
//        // Empty set
//        array.add(new HashSet<Integer>());
//
//        allSubs(fullset, array);
//        return array;
//    }
//
//    static void allSubs(HashSet<Integer> set, HashSet<HashSet<Integer>> array) {
//        // Base case
//        if (set.isEmpty())
//            return;
//        else {
//            Integer[] iter = set.toArray(new Integer[0]);
//
//            array.add(new HashSet<Integer>(set));
//            for (Integer i : iter) {
//                set.remove(i);
//                allSubs(set, array);
//                set.add(i);
//            }
//        }
//    }

    // Better algorithm - uses the logic that new subsets are created by
    // adding new sets that are the current sets plus the new value.
    // Should be (2^n - 1) * n
    static ArrayList<HashSet<Integer>> allSubsets(HashSet<Integer> fullset) {
        ArrayList<HashSet<Integer>> array = new ArrayList<>();
        array.add(new HashSet<>());

        for (Integer i : fullset) {
            int size = array.size();
            for (int j = 0; j < size; j++) {
                array.add(new HashSet<>(array.get(j)));
                array.get(array.size() - 1).add(i);
            }
        }
        return array;
    }

    public static void main(String args[]) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        System.out.println(allSubsets(hs));
    }
}