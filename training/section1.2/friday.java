
/*
ID: yk18031
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

    int N = Integer.parseInt(f.readLine());
    Year[] years = new Year[N];

    String[] days = { "M", "TU", "W", "TH", "F", "SA", "SU" };
    int[] thirteenDays = new int[7];


    for (int i = 1900; i < 1900 + N; i++) {
      years[i-1900] = new Year(i);
    }
    
    int totalday=2;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < years[i].getTotalDays(); j++) {
        years[i].nextDay();
        totalday++;
        if (years[i].getDay() == 13) {
          thirteenDays[totalday % 7]++;
        }
      }
    }
    
    for (int i = 0; i < 7; i++) {
      if (i == 6) {
        out.print(thirteenDays[i]);
      } else {
        out.print(thirteenDays[i] + " ");
      }

    }
    out.println();


    out.close();
  }
}

class Year {
  int totalDays;
  int year;
  int february;
  int month = 1;
  int day=1;

  public Year(int year) {
    this.year = year;
    int february;
    if (isLeap(year)) {
      february = 29;
    } else {
      february = 28;
    }
    this.february = february;
    this.totalDays = 337 + february;
  }
  
  public void print() {
    System.out.println("the month:" + this.month + " day: " + this.day);
  }
  
  public int getDay() {
    return this.day;
  }
  public int getTotalDays() {
    return this.totalDays;
  }

  public void nextDay() {
    if (((this.month == 1)||(this.month == 3)||(this.month == 5)||(this.month == 10)||(this.month == 12)
        || (this.month == 7) || (this.month == 8)) && (this.day == 31)) {
      this.day = 0;
      this.month++;
    } else if (((this.month == 4)||(this.month == 6)||(this.month == 9)||(this.month == 11)) && (this.day == 30)) {
      this.day = 0;
      this.month++;
    } else if ((this.month == 2) && (this.day == this.february)) {
      this.day = 0;
      this.month++;
    }
    this.day++;
    if (this.month > 12) {
      this.month = 1;
    }
    
  }
  public boolean isLeap(int year){
    if (year % 100 == 0) {
      if (year % 400 == 0) {
        return true;
      } else {
        return false;
      }
    } else if (year % 4 == 0) {
      return true;
    } else {
      return false;
    }
  }
}