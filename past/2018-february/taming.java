
/*
ID: yk18031
LANG: JAVA
TASK: taming
*/
import java.io.*;
import java.util.*;

class taming {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("taming.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));

    int N = Integer.parseInt(f.readLine());
    int[] ary = new int[N];

    StringTokenizer st = new StringTokenizer(f.readLine());
    for (int i = 0; i < N; i++) {
      ary[i] = Integer.parseInt(st.nextToken());
    }

    int max=0, min = 0;
    int temp = -1;
    int i;

    for (i = N - 1; i >= 0; i--) {
      if (i == 0) {
        max++;
        min++;
        break;
      }
      if (ary[i] > 0) {
        if (temp == ary[i]) {
          out.println(-1);
          break;
        }
        temp = ary[i];

      } else if (ary[i] == 0) {
        temp = 0;
        max++;
        min++;
      } else {
        temp--;
        if (temp == 0) {
          max++;
          min++;
        } else if (temp < 0) {
          max++;
        }
      }
    }
    if (i == 0) {
      out.println(min + " " + max);
    }
    

    out.close();
  }
}
