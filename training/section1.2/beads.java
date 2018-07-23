
/*
ID: yk18031
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

    int n = Integer.parseInt(f.readLine());
    String s = f.readLine();
    s += s;
    char[] beads = s.toCharArray();

    int[] count1 = new int[n * 2]; // forward count
    int[] count2 = new int[n * 2]; // backward count

    // forward counting
    int redCount = 0;
    int blueCount = 0;

    // backward counting
    int redCount2 = 0;
    int blueCount2 = 0;

    for (int i = 0; i < n * 2; i++) {
      redCount = (beads[i] == 'r' || beads[i] == 'w') ? redCount + 1 : 0;
      blueCount = (beads[i] == 'b' || beads[i] == 'w') ? blueCount + 1 : 0;
      count1[i] = Math.max(redCount, blueCount);

      redCount2 = (beads[n * 2 - 1 - i] == 'r' || beads[n * 2 - 1 - i] == 'w') ? redCount2 + 1 : 0;
      blueCount2 = (beads[n * 2 - 1 - i] == 'b' || beads[n * 2 - 1 - i] == 'w') ? blueCount2 + 1 : 0;
      count2[n * 2 - 1 - i] = Math.max(redCount2, blueCount2);
    }
    int maxSum = 0;
    
    for (int i = 0; i < 2 * n - 1; i++) {
      int sum = count1[i] + count2[i + 1];
      if (sum > maxSum) {
        maxSum = sum;
      }
    }

    // System.out.println(Math.min(maxSum, n));
    out.println(Math.min(maxSum, n));
    out.close();
  }
}
