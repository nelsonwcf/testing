package scraps;

import java.util.HashMap;
import java.util.HashSet;

public class ReferenceEqualityTest {
  public static void main(String[] args) {
    HashSet<Object> hs = new HashSet<>();
    HashMap hm1 = new HashMap<>();
    HashMap hm2 = new HashMap<>();
    hs.add(hm1);
    hm1.put((Integer) 1, (String) "Dragon");
    hm2.put((Integer) 1, (String) "Dragon");
    hs.add(hm2);
  }

}
