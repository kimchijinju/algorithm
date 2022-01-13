package boj;

import java.util.Scanner;

public class sol1904 {

    static int[] seq = new int[1_000_001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        System.out.println(dp(N));

    }

    private static int dp(int n) {
        if (n == 1)
            return seq[1] = 1;

        if (n == 2)
            return seq[2] = 2;

        if (seq[n] != 0)
            return seq[n];

        return seq[n] = (dp(n - 2) + dp(n - 1)) % 15746;
    }
}
