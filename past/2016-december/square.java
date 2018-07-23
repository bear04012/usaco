
/*
ID: yk18031
LANG: JAVA
TASK: square
*/
import java.io.*;
import java.util.*;

class square {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("square.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());
    int x1 = Integer.parseInt(st.nextToken());
    int y1 = Integer.parseInt(st.nextToken());
    int x2 = Integer.parseInt(st.nextToken());
    int y2 = Integer.parseInt(st.nextToken());
    Rect r1 = new Rect(x1, x2, y1, y2);

    st = new StringTokenizer(f.readLine());
    x1 = Integer.parseInt(st.nextToken());
    y1 = Integer.parseInt(st.nextToken());
    x2 = Integer.parseInt(st.nextToken());
    y2 = Integer.parseInt(st.nextToken());
    Rect r2 = new Rect(x1, x2, y1, y2);

    int xDiff,yDiff;

    xDiff = Math.max(r1.x2, r2.x2) - Math.min(r1.x1, r2.x1);
    yDiff = Math.max(r1.y2, r2.y2) - Math.min(r1.y1, r2.y1);


    int side = Math.max(xDiff, yDiff);

    out.println(side * side);



    out.close();
  }
}

class Rect {
  int x1, x2, y1, y2;

  public Rect(int x1, int x2, int y1, int y2) {
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;

  }
  
  public void print() {
    System.out.println(this.x1);
    System.out.println(this.y1);
    System.out.println(this.x2);
    System.out.println(this.y2);
  }

}