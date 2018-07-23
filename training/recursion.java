class recursion {
  public static void main(String[] args) {

    int sum = 0;
    int prev = 1;
    int sum2;

    for (int i = 0; i < 8 - 2; i++) {
      sum2 = prev + sum;
      sum = prev;
      prev = sum2;
      System.out.println(sum2);
    }

    int sum3 = fib(8);
    System.out.println(sum3);

  }

  static int fib(int n) {
    if (n == 2)
      return 1;
    if (n == 1)
      return 0;



    
    return fib(n-1) + fib(n-2);
  }


}