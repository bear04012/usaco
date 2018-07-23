
/*
ID: yk18031
LANG: JAVA
TASK: lifeguards
*/
import java.io.*;
import java.util.*;

class lifeguards {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

    int n = Integer.parseInt(f.readLine());

    lifeguard[] people = new lifeguard[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(f.readLine());
      people[i] = new lifeguard(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    int maxTime = 0;
    for (int skipIndex = 0; skipIndex < n; skipIndex++) {
      int coveredTime = getCoveredTime(skipIndex, people);
      maxTime = Math.max(maxTime, coveredTime);
    }

    out.println(maxTime);

    // StringTokenizer st = new StringTokenizer(f.readLine());
    // int i1 = Integer.parseInt(st.nextToken()); // first integer
    // int i2 = Integer.parseInt(st.nextToken()); // second integer
    // out.println(i1+i2); // output result
    out.close(); // close the output file
  }
  
  static int getCoveredTime(int skipIndex, lifeguard[] people) {
    int coveredTime=0;
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < people.length; j++) {
        if (skipIndex == j) {
          continue;
        }
        if (people[j].isCovered(i)) {
          coveredTime++;
          break;
        }
      }
    }
    return coveredTime;
  }
}

class lifeguard implements Comparable<lifeguard> {
  int startpoint;
  int endpoint;

  public lifeguard(int start, int end) {
    this.startpoint = start;
    this.endpoint = end;
  }

  @Override
  public int compareTo(lifeguard o) {
    return this.startpoint - o.startpoint;
  }

  public boolean isCovered(int time) {
    return (startpoint<=time && endpoint >time);
  }

  public void print() {
    System.out.println(this.startpoint + " " + this.endpoint);
  }

}
