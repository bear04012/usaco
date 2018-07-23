
/*
ID: yk18031
LANG: JAVA
TASK: tttt
*/
import java.io.*;
import java.util.*;

class tttt {
  static Map<String, Integer> map = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("tttt.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

    char[][] board = new char[3][3];


    for (int i = 0; i < 3; i++) {
      String line = f.readLine();
      for (int j = 0; j < 3; j++) {
        board[i][j] = line.charAt(j);
      }
    }

    

    getWinner(board);
    int single=0;
    int doub = 0;
    System.out.println(map);
    for (String str : map.keySet()) {
      if (str.charAt(0)>='A' && str.charAt(0)<='Z') {
        doub++;
      } else {
        single++;
      }
    }
    out.println(single);
    out.println(doub);

    out.close();
  }
  
  static void getWinner(char[][] board) {
    char charAry[] = new char[2];
    
    for (int i = 0; i < board.length; i++) {
      char[] row = board[i];
      if (row[0] == row[1] || row[1] == row[2]|| row[2]==row[0]) {
        charAry[0] = row[0];
        if (charAry[0] != row[1]) {
          charAry[1] = row[1];
        } else if (charAry[0]!=row[2]) {
          charAry[1] = row[2];
        }
        Arrays.sort(charAry);
        String sorted = new String(charAry);
        map.put(sorted, 1);
        charAry = new char[2];
      }
    }
    for (int i = 0; i < board.length; i++) {

      if (board[0][i] == board[1][i] || board[1][i] == board[2][i]|| board[0][i]==board[2][i]) {
        charAry[0] = board[0][i];
        if (charAry[0] != board[1][i]) {
          charAry[1] = board[1][i];
        } else if (charAry[0]!=board[2][i]){
          charAry[1] = board[2][i];
        }
        Arrays.sort(charAry);
        String sorted = new String(charAry);
        map.put(sorted, 1);
        charAry = new char[2];

      }
    }


    if (board[0][0] == board[1][1] || board[1][1] == board[2][2] || board[0][0]==board[2][2]) {
      charAry[0] = board[0][0];
      if (charAry[0] != board[1][1]) {
        charAry[1] = board[1][1];
      } else if (charAry[0] != board[2][2]) {
        charAry[1] = board[2][2];
      }
      Arrays.sort(charAry);
      String sorted = new String(charAry);
      map.put(sorted, 1);
      charAry = new char[2];
    }
    else if (board[0][2] == board[1][1] || board[1][1] == board[2][0]||board[0][2]==board[2][0]) {
      charAry[0] = board[0][2];
      if (charAry[0] != board[1][1]) {
        charAry[1] = board[1][1];
      } else if (charAry[0] != board[2][0]) {
        charAry[1] = board[2][0];
      }
      Arrays.sort(charAry);
      String sorted = new String(charAry);
      map.put(sorted, 1);
      charAry = new char[2];
    } 
  }

}