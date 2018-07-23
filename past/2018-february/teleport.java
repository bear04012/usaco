
/*
ID: yk18031
LANG: JAVA
TASK: teleport
*/
import java.io.*;
import java.util.*;

class teleport {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int tp1 = Integer.parseInt(st.nextToken());
    int tp2 = Integer.parseInt(st.nextToken());


    int path = 0;
    if (Math.abs(a - tp1) > Math.abs(a - tp2)) {
      path += Math.abs(a - tp2);
      path += Math.abs(b - tp1);
    } else {
      path += Math.abs(a - tp1);
      path += Math.abs(b - tp2);
    }

    out.println(Math.min(Math.abs(b - a), path));
    

    out.close();

  }
}
