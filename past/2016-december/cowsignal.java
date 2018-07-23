
/*
ID: yk18031
LANG: JAVA
TASK: cowsignal
*/
import java.io.*;
import java.util.*;

class cowsignal {

  static Map<Character, Integer> set = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    String[] lines = new String[M];

    for (int i = 0; i < M; i++) {
      lines[i] = f.readLine();
    }

    
    for (int j = 0; j < M; j++) {
      String newLine = "";
      for (int i = 0; i < lines[j].length(); i++) {
        for (int x = 0; x < K; x++) {
          newLine += lines[j].charAt(i);
        }
      
      }
      lines[j] = newLine;
    }

    ArrayList<String> newLines = new ArrayList<String>();
    
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < K; j++) {
        newLines.add(lines[i]);
      }
    }

    for (int i = 0; i < newLines.size(); i++){
      out.println(newLines.get(i));
    }

    out.close();
  }
}