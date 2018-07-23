
/*
ID: yk18031
LANG: JAVA
TASK: measurement
*/
import java.io.*;
import java.util.*;

class measurement {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

    int numdays = Integer.parseInt(f.readLine());
    Cow[] cows = new Cow[numdays];

    StringTokenizer st;

    for (int i = 0; i < numdays; i++) {
      st = new StringTokenizer(f.readLine());
      cows[i] = new Cow(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()));
    }
    Arrays.sort(cows);

    int change = 0;
    String name = "";

    Map<String, Integer> map = new HashMap<>();
    for (Cow val : cows) {
      map.put(val.name, 0);
    }

    for (Cow val : cows) {
      map.put(val.name, map.get(val.name) + val.difference);
      String newName = getFirst(map);
      if (!newName.equals(name)) {
        name = newName;
        change++;
      }
    }
    System.out.println(map);

    out.println(change);

    // StringTokenizer st = new StringTokenizer(f.readLine());
    // int i1 = Integer.parseInt(st.nextToken()); // first integer
    // int i2 = Integer.parseInt(st.nextToken()); // second integer
    // out.println(i1+i2); // output result
    out.close(); // close the output file
  }
  
  static String getFirst(Map<String,Integer> map) {
    String newName = "";

    int max = -10;

    for (String name : map.keySet()) {
      int value = map.get(name);
      if (value > max) {
        max = value;
      }
    }

    for (String name : map.keySet()) {
      if (max == map.get(name)) {
        newName += name;
      }
    }
    return newName;
  }
}

class Cow implements Comparable<Cow> {
  int day;
  String name;
  int difference;

  public Cow(int day,String name, int difference) {
    this.day = day;
    this.name = name;
    this.difference = difference;

  }


  @Override
  public int compareTo(Cow o) {
    return this.day - o.day;
  }

  public void print() {
    System.out.println(this.day+" "+this.name+" "+this.difference);
  }
}
