package boj;

import java.util.Scanner;

public class sol1003 {
    static int[] fibonacci = new int[41];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int j = scanner.nextInt();

            if (j == 0) {
                System.out.println("1 0");
                continue;
            }
            if (j == 1) {
                System.out.println("0 1");
                continue;
            }

            fibonacci(j);
            System.out.println(fibonacci[j - 1] + " " + fibonacci[j]);
        }


    }

    private static int fibonacci(int n) {
        if (n == 0) {
            fibonacci[0] = 0;
            return fibonacci[0];
        }

        if (n == 1) {
            fibonacci[1] = 1;
            return fibonacci[1];
        }

        if (fibonacci[n] != 0)
            return fibonacci[n];

        return fibonacci[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

}
