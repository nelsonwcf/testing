import java.util.*;

class AnagramSubsetsSolution {
  static private Set<Set<String>> getAnagramSubsets(Set<String> set) {
    if (set == null) {
      return null;
    }

    Set<Set<String>> sets = new HashSet<>();

    if (set.size() == 1) {
      return sets;
    }

    Map<Integer, Set<String>> map = new HashMap<>();

    for (String s : set) {
      int sHashCode = getHashOnAnagram(s);

      if (!map.containsKey(sHashCode)) {
        Set<String> subset = new HashSet<>();
        subset.add(s);
        map.put(sHashCode, subset);
      } else {
        map.get(sHashCode).add(s);
      }
    }

    for (int n : map.keySet()) {
      if (map.get(n).size() > 1) {
        sets.add(map.get(n));
      }
    }

    return sets;
  }

  static private int getHashOnAnagram(String str) {
    Map<Character, Integer> hm = new HashMap<>();

    for (char c : str.toCharArray()) {
      if (!hm.containsKey(c)) {
        hm.put(c, 1);
      } else {
        hm.put(c, hm.get(c) + 1);
      }
    }

    return hm.hashCode();
  }

  public static void main(String[] args) {
    HashSet<String> hs = new HashSet<>(Arrays.asList("asdf", "fdsa", "qwer", "aabbcc", "bbccaa", "cacabb"));
    System.out.println(getAnagramSubsets(hs));
  }
}