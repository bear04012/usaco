
/*
ID: yk18031
LANG: JAVA
TASK: notlast
*/
import java.io.*;
import java.util.*;

class notlast {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("notlast.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());
    int N = Integer.parseInt(st.nextToken());
    String[] names = new String[N];
    Map<String, Integer> m = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(f.readLine());
      String name = st.nextToken();
      if (!m.containsKey(name)) {
        m.put(name, 0);
      }
      names[i] = name;
      m.put(name, m.get(name) + Integer.parseInt(st.nextToken()));
    }

    

    ArrayList<String> cowNames = new ArrayList<String>();

    int least = 1000;
    int secondLeast = 1000;
    for (int i = 1; i < names.length; i++) {
      if (least > m.get(names[i])) {
        System.out.println("Testing " + secondLeast);
        secondLeast = least;
        least = m.get(names[i]);
      } else if (least < m.get(names[i]) && secondLeast > m.get(names[i])) {
        secondLeast = m.get(names[i]);
      }
    }

    for (String name : m.keySet()) {
      if (m.get(name) == secondLeast) {
        cowNames.add(name);
      }
    }

    if (names.length == 1) {
      out.println(names[0]);
    }else if (cowNames.size() > 1 || cowNames.size()==0) {
      out.println("Tie");
    } else if (cowNames.size() == 1) {
      out.println(cowNames.get(0));
    }


    System.out.println(m);
    out.close();
  }
}