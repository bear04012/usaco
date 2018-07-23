
/*
ID: yk18031
LANG: JAVA
TASK: billboard
*/
import java.io.*;
import java.util.*;

class billboard {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

    int x1, x2, y1, y2;

    StringTokenizer st = new StringTokenizer(f.readLine());
    x1 = Integer.parseInt(st.nextToken());
    y1 = Integer.parseInt(st.nextToken());
    x2 = Integer.parseInt(st.nextToken());
    y2 = Integer.parseInt(st.nextToken());
    Rect billboard = new Rect(x1, x2, y1, y2);

    st = new StringTokenizer(f.readLine());
    x1 = Integer.parseInt(st.nextToken());
    y1 = Integer.parseInt(st.nextToken());
    x2 = Integer.parseInt(st.nextToken());
    y2 = Integer.parseInt(st.nextToken());
    Rect tarp = new Rect(x1, x2, y1, y2);

    boolean c1 = tarp.contains(billboard.x1 + 0.5, billboard.y2 - 0.5);
    boolean c2 = tarp.contains(billboard.x2 - 0.5, billboard.y2 - 0.5);
    boolean c3 = tarp.contains(billboard.x2 - 0.5, billboard.y1 + 0.5);
    boolean c4 = tarp.contains(billboard.x1 + 0.5, billboard.y1 + 0.5);

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);

    switch ((c1?1:0) + (c2?1:0) + (c3?1:0) + (c4?1:0)) {
      case 0:
      case 1:
        out.println((billboard.x2-billboard.x1)*(billboard.y2-billboard.y1));
        break;
      case 2:
        if(c1&&c2){
          out.println((billboard.x2-billboard.x1)*(tarp.y1 - billboard.y1));
        }else if (c4&&c3) {
          out.println((billboard.x2-billboard.x1)*(billboard.y2 - tarp.y2));
        }else if (c1&&c4) {
          out.println((billboard.x2-tarp.x2)*(billboard.y2-billboard.y1));
        }else if (c2&&c3){
          out.println((tarp.x1-billboard.x1)*(billboard.y2-billboard.y1));
        }break;
      case 3:
      case 4:
      default:
       out.println(0);
       break;
    }

    // StringTokenizer st = new StringTokenizer(f.readLine());
    // int i1 = Integer.parseInt(st.nextToken()); // first integer
    // int i2 = Integer.parseInt(st.nextToken()); // second integer
    // out.println(i1+i2); // output result
    out.close(); // close the output file
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

  public boolean contains(double x, double y) {
    return x>x1 && x<x2 && y>y1 && y<y2;
  }

  public void print() {
    System.out.println(this.x1);
    System.out.println(this.y1);
    System.out.println(this.x2);
    System.out.println(this.y2);

  }
}