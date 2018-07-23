
/*
ID: yk18031
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

    String line1 = f.readLine();
    int value1 = getValue(line1);

    String line2 = f.readLine();
    int value2 = getValue(line2);

    if (value1 == value2) {
      out.println("GO");
    } else {
      out.println("STAY");
    }
    

    // StringTokenizer st = new StringTokenizer(f.readLine());
    // int i1 = Integer.parseInt(st.nextToken());    // first integer
    // int i2 = Integer.parseInt(st.nextToken());    // second integer
    // out.println(i1+i2);                           // output result
    out.close(); // close the output file
  }
  
  public static int getValue(String line) {
    int value = 1;
    for (int i = 0; i < line.length(); i++) {
      int a = line.charAt(i) - 'A' + 1;
      value *= a;
    }
    return value%47;
  }
}