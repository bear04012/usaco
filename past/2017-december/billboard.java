
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
    Rect rect1 = new Rect(x1, x2, y1, y2);

    st = new StringTokenizer(f.readLine());
    x1 = Integer.parseInt(st.nextToken());
    y1 = Integer.parseInt(st.nextToken());
    x2 = Integer.parseInt(st.nextToken());
    y2 = Integer.parseInt(st.nextToken());
    Rect rect2 = new Rect(x1, x2, y1, y2);

    st = new StringTokenizer(f.readLine());
    x1 = Integer.parseInt(st.nextToken());
    y1 = Integer.parseInt(st.nextToken());
    x2 = Integer.parseInt(st.nextToken());
    y2 = Integer.parseInt(st.nextToken());
    Rect billboard = new Rect(x1, x2, y1, y2);

    int piledArea1 = rect1.getPiledArea(billboard);
    int piledArea2 = rect2.getPiledArea(billboard);

    out.print((rect1.area + rect2.area) - (piledArea1 + piledArea2));
    // StringTokenizer st = new StringTokenizer(f.readLine());
    // int i1 = Integer.parseInt(st.nextToken()); // first integer
    // int i2 = Integer.parseInt(st.nextToken()); // second integer
    // out.println(i1+i2); // output result
    out.close(); // close the output file
  }
}

class Rect {
  int x1, x2, y1, y2;
  int area;

  public Rect(int x1, int x2, int y1, int y2) {
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
    this.area = (x2 - x1) * (y2 - y1);

  }

  public int getPiledArea(Rect billboard) {
    int x1,x2,y1,y2;

    if (this.x1 < billboard.x1) {
      x1 = billboard.x1;
    } else {
      x1 = this.x1;
    }
    if (this.x2 > billboard.x2) {
      x2 = billboard.x2;
    } else {
      x2 = this.x2;
    }
    if (this.y1 > billboard.y1) {
      y1 = this.y1;
    } else {
      y1 = billboard.y1;
    }
    if (this.y2 > billboard.y2) {
      y2 = billboard.y2;
    } else {
      y2 = this.y2;
    }

    if ((x2-x1<0) || (y2 - y1 <0)) {
      return 0;
    } else {
      return (x2 - x1) * (y2 - y1);
    }
    


    // int presentX;
    // int piledX;
    // int maxX = (this.x2 - this.x1) + (billboard.x2 - billboard.x1);
    // if (this.x2 > billboard.x2) {
    //   if (this.x1 < billboard.x1) {
    //     presentX = this.x2 - this.x1;
    //   } else {
    //     presentX = this.x2 - billboard.x1;
    //   }
    // } else {
    //   if (this.x1 > billboard.y1) {
    //     presentX = billboard.x2 - billboard.x1;
    //   } else {
    //     presentX = billboard.x2 - this.x1;
    //   }
    // }
    // piledX = maxX - presentX;

    // int presentY;
    // int piledY;
    // int maxY = (this.y2 - this.y1) + (billboard.y2 - billboard.y1);
    // if (this.y2 > billboard.y2) {
    //   if (this.y1 < billboard.y1) {
    //     presentY = (this.y2 - y1);
    //   } else {
    //     presentY = this.y2 - billboard.y1;
    //   }
    // } else {
    //   if (this.y1 > billboard.y1) {
    //     presentY = billboard.y2 - billboard.y1;
    //   } else {
    //     presentY = billboard.y2 - this.y1;
    //   }
    // }
    // piledY = maxY - presentY;

    // return piledX * piledY;

  }

  public void print() {
    System.out.println(this.x1);
    System.out.println(this.y1);
    System.out.println(this.x2);
    System.out.println(this.y2);

    System.out.println("The area is " + this.area);
  }
}