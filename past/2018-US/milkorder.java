
/*
ID: yk18031
LANG: JAVA
TASK: milkorder
*/
import java.io.*;
import java.util.*;

class milkorder {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("milkorder.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[] ary = new int[N + 1];

    int H = Integer.parseInt(st.nextToken());
    int[] hierachy = new int[H];

    int S = Integer.parseInt(st.nextToken());
    int[] helper = new int[N + 1];

    st = new StringTokenizer(f.readLine());

    for (int i = 0; i < H; i++) {
      hierachy[i] = Integer.parseInt(st.nextToken());
    }
    int hierachyOne = -1;
    hierachyOne = checkOne(hierachy);

    for (int i = 0; i < S; i++) {
      st = new StringTokenizer(f.readLine());
      int num = Integer.parseInt(st.nextToken());
      int index = Integer.parseInt(st.nextToken());
      helper[num] = index;
      ary[index] = num;
    }

    for (int i = 1; i < ary.length; i++) {
      System.out.println(ary[i]);

    }

    if (hierachyOne >= 0) {
      
      int start = getStartIndex(hierachyOne, hierachy, ary);
      System.out.println(ary[start]);
      int left = checkLeftOver(ary[start], hierachy);
      System.out.println(left);
      for (int i = start; i < ary.length; i++) {
        if (ary[i] == 0 && left==1) {
          out.println(i);
          break;
        } else if (ary[i] == 0 && left > 1) {
          left--;
        }
      }
    } else {
      int h = 0;
      int candidateIndex = -1;
      for (int i = 1; i < ary.length; i++) {
        int selectedIndex = helper[hierachy[h]];
        System.out.println("selected: " + selectedIndex);
        System.out.println("candidate: " + candidateIndex);

        if (ary[i] == 0) {
          int next = hierachy[h];
          if (i < selectedIndex) {
            out.println(candidateIndex);
            break;
          } else if (selectedIndex > 0) {
            h++;
          }
          candidateIndex = i;
          ary[i] = next;
          h++;
          if (h >= hierachy.length) {
            out.println(candidateIndex);
            break;
          }
        }
        

        if (ary[i] == 0 && i < selectedIndex) {
          out.println(candidateIndex);
          break;
        } else if (ary[i] == 0) {
          int next = hierachy[h];
          ary[i] = next;
          System.out.println("ary[i]=" + ary[i]);
          candidateIndex = i;
        }
      }
     

    }

    

    out.close();
  }

  static int checkOne(int[] hierachy) {
    for (int i = 0; i < hierachy.length; i++) {
      if (hierachy[i] == 1) {
        return i;
      }
    }
    return -1;
  }
  
  static int getStartIndex(int indexOne, int[] hierachy, int[] ary) {
    for (int i = indexOne; i >= 0; i--) {
      for (int j = 1; j < ary.length; j++) {
        if (hierachy[i] == ary[j]) {
          return j;
        }
      }
    }
    return 1;
  }

  static int checkLeftOver(int n, int[] hierachy) {
    int oneAt =0;
    int startAt =0;
    for (int i = 0; i < hierachy.length; i++) {
      if (hierachy[i] == n) {
        startAt = i;
      }
      if (hierachy[i] == 1) {
        oneAt = i;
      }
    }
    if (startAt == 0) {
      startAt = -1;
    }
    if (hierachy[0] == n) {
      startAt = 0;
    }
    
    return oneAt - startAt;
  }
}
