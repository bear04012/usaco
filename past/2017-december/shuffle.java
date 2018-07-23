
/*
ID: yk18031
LANG: JAVA
TASK: shuffle
*/
import java.io.*;
import java.util.*;

class shuffle {
  static int[] order;
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

    int numCows = Integer.parseInt(f.readLine());
    StringTokenizer st = new StringTokenizer(f.readLine());
    
    order = new int[numCows + 1];
    int[] lastOrder = new int[numCows+1];
    int[] firstOrder = new int[numCows+1];

    for (int i = 0; i < numCows; i++) {
      order[Integer.parseInt(st.nextToken())] = i + 1;
    }

    st = new StringTokenizer(f.readLine());
    for (int i = 0; i < numCows; i++) {
      lastOrder[i + 1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < numCows; i++) {
      int newIndex;
      newIndex = getNewIndex(i+1);
      firstOrder[newIndex] = lastOrder[i + 1];
    }

    for (int i = 0; i < numCows; i++) {
      out.println(firstOrder[i + 1]);
    }

    // StringTokenizer st = new StringTokenizer(f.readLine());
    // int i1 = Integer.parseInt(st.nextToken()); // first integer
    // int i2 = Integer.parseInt(st.nextToken()); // second integer
    // out.println(i1+i2); // output result
    out.close(); // close the output file
  }

  public static int getNewIndex(int index) {
    return order[order[order[index]]];
  }
}
