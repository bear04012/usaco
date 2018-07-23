
/*
ID: yk18031
LANG: JAVA
TASK: hoofball
*/
import java.io.*;
import java.util.*;

class hoofball {
  static ArrayList<Integer> values = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));

    int N = Integer.parseInt(f.readLine());
    int[] ary = new int[N];

    StringTokenizer st = new StringTokenizer(f.readLine());

    for (int i = 0; i < N; i++) {
      ary[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(ary);

    for (int val : ary) {
      System.out.println(val);
    }

    out.println();
  }

  static int endNum(int index, int[] ary) {
    if (index == 0) {
      return ary[index] > ary[index];
    } else if(index==ary.length) {

    } else {

    }
    
  }
};