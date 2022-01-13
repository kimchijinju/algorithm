package boj;

import java.util.Scanner;

public class sol9184 {

    static int[][][] w = new int[51][51][51];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
        while (canLoop(a, b, c)) {
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + recursion(a, b, c));
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
        }

    }

    private static boolean canLoop(int a, int b, int c) {
        return a != -1 || b != -1 || c != -1;
    }

    private static int recursion(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (w[a][b][c] != 0)
            return w[a][b][c];
        if (a > 20 || b > 20 || c > 20)
            return w[a][b][c] = recursion(20, 20, 20);
        if (a < b && b < c)
            return w[a][b][c] = recursion(a, b, c - 1) + recursion(a, b - 1, c - 1)
                    - recursion(a, b - 1, c);

        return w[a][b][c] = recursion(a - 1, b, c) + recursion(a - 1, b - 1, c)
                + recursion(a - 1, b, c - 1) - recursion(a - 1, b - 1, c - 1);

    }
}
