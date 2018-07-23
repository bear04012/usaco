
/*
ID: yk18031
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

    int maxPiled = 0;

    int empty = 0;

    int N = Integer.parseInt(f.readLine());
    farmer[] farmers = new farmer[N];
    
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(f.readLine());
      farmers[i] = new farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    int minBegin = farmers[0].begin;
    int maxEnd = farmers[0].end;
    
    for (int i = 0; i < farmers.length; i++) {
      if (maxEnd < farmers[i].end) {
        maxEnd = farmers[i].end;
      }
      if (minBegin > farmers[i].begin) {
        minBegin = farmers[i].begin;
      }
    }

    int piled = 0;
    int idle = 0;
    int MaxPiled = 0;
    int maxIdle = 0;

    for (int i = minBegin; i < maxEnd; i++) {

      if (allContained(i, farmers)) {

        if (idle >= maxIdle) {
          maxIdle = idle;
          idle = 0;
        }
        piled++;
        
      } else {
        if (piled >= MaxPiled) {
          MaxPiled = piled;
          piled = 0;
        }
        idle++;
      }
    }
    



    if (piled >= MaxPiled) {
      MaxPiled = piled;
    }
    if (idle >= maxIdle) {
      maxIdle = idle;
    }

    out.println(MaxPiled + " " + maxIdle);
    out.close();
  }

  static boolean allContained(int t,farmer[] farmers) {
    for (int j = 0; j < farmers.length; j++) {
      if (farmers[j].isContained(t)) {
        return true;
      }
    }
    return false;
  }
}


class farmer {
  int begin;
  int end;
  
  public farmer(int begin, int end) {
    this.begin = begin;
    this.end = end;
  }

  public boolean isContained(int t) {
    return (this.begin <= t && t < this.end);
  }

  public void print() {
    System.out.println(this.begin + " " + this.end);
  }

}