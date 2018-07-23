
/*
ID: yk18031
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));


    Map<String, Integer> map = new HashMap<>();

    int N = Integer.parseInt(f.readLine());
    String[] names = new String[N];
    for (int i = 0; i < N; i++) {
      String name = f.readLine();
      names[i] = name;
      map.put(name, 0);
    }
    int cnt = 0;
    while (cnt < names.length) {

      String name = f.readLine();

      StringTokenizer st = new StringTokenizer(f.readLine());
      int amount = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      
      if (num > 0) {
        map.put(name, map.get(name) + (amount % num) - amount);
        for (int i = 0; i < num; i++) {
          String newName = f.readLine();
          map.put(newName, map.get(newName) + (amount / num));
        }
      } else {
      }
      
      
      System.out.println(map);
      cnt++;
    }
    
    for (int i = 0; i < names.length; i++) {
      out.println(names[i] + " " + map.get(names[i]));
    }

    out.close();
  }
}