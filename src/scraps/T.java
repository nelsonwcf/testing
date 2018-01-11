package scraps;

public class T {
  static String decrypt(String word) {
    // your code goes here
    StringBuilder res=new StringBuilder();
    int[] ascii=new int[word.length()];
    ascii[0]=(int)word.charAt(0);
    int[] asciiMod=new int[word.length()];
    asciiMod[0]=(int)word.charAt(0);
    for(int i=1;i<word.length();i++){
      ascii[i]=(int)word.charAt(i);
      asciiMod[i]  -=ascii[i-1];
      while(asciiMod[i]<97)
        asciiMod[i]+=26;
    }
    asciiMod[0]-=1;
    for(int i=0;i<asciiMod.length;i++){
      char ch=(char)asciiMod[i];
      res.append(ch);
    }
    return res.toString();
  }

  public static void main(String[] args) {
    System.out.println(decrypt("dnotq"));
  }
}
