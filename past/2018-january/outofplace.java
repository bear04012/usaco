
/*
ID: yk18031
LANG: JAVA
TASK: outofplace
*/
import java.io.*;
import java.util.*;

class outofplace {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

    int n = Integer.parseInt(f.readLine());

    int[] ary = new int[n];
    for (int i = 0; i < n; i++) {
      ary[i] = Integer.parseInt(f.readLine());
    }

    int cnt = 0;

    for (int i = n - 1; i > -1; i--) {
      int selected = ary[i];
      int max = ary[i];
      int index = -1;
      for (int j = 0; j < i; j++) {
        if (max < ary[j]) {
          max = ary[j];
          index = j;
        }
      }
      if (selected < max) {
        ary[i] = max;
        ary[index] = selected;
        cnt++;
      }
    }
    out.println(cnt);



    // StringTokenizer st = new StringTokenizer(f.readLine());
    // int i1 = Integer.parseInt(st.nextToken()); // first integer
    // int i2 = Integer.parseInt(st.nextToken()); // second integer
    // out.println(i1+i2); // output result
    out.close(); // close the output file
  }

}