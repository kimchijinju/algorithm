package boj;

import java.util.Scanner;

public class sol11050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(foo(n) / (foo(k) * foo (n - k)));
    }

    static int foo(int n) {
        if(n == 1 || n == 0)
            return 1;
        return n * foo(n - 1);
    }
}
