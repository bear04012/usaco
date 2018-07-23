
/*
ID: yk18031
LANG: JAVA
TASK: blocks
*/
import java.io.*;
import java.util.*;

class blocks {

  static Map<Character, Integer> set = new HashMap<>();
  static Map<Character, Integer> finalSet = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

    int N = Integer.parseInt(f.readLine());

    Side[] sides = new Side[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(f.readLine());
      sides[i] = new Side(st.nextToken(), st.nextToken());
    }


    for (int i = 0; i < N; i++) {

      for (int j = 0; j < 2; j++) {

        for (int x = 0; x < sides[i].words[j].length(); x++) {
          set.put(sides[i].words[j].charAt(x), 1);
          System.out.println(set);
          
        }

      }
      
      for (char letter : set.keySet()) {
        if (finalSet.containsKey(letter)) {
          finalSet.put(letter, finalSet.get(letter) + set.get(letter));
          set.remove(letter);
          

        } else {
          finalSet.put(letter, 1);
        }

      }
      // System.out.println(finalSet);
    }





    out.close();
  }
}

class Side {
  String[] words = new String[2];
  boolean shown = false;

  public Side(String word1, String word2) {
    this.words[0] = word1;
    this.words[1] = word2;
  }

  public void print() {
    System.out.println(this.words[0]);
  }
}