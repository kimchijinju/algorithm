package boj;

import java.io.*;
import java.util.Scanner;

public class sol9461 {
    static long[] sequence = new long[101];

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            System.out.println(P(N));
        }
    }

    private static long P(int n) {
        if (sequence[n] != 0)
            return sequence[n];

        if (n == 1 || n == 2 || n == 3)
            return sequence[n] = 1;
        if (n == 4 || n == 5)
            return sequence[n] = 2;

        return sequence[n] = P(n - 1) + P(n - 5);
    }
}
