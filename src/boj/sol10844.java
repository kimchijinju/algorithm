package boj;

import java.util.Scanner;

public class sol10844 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] dp = new int[N][10];

        for (int i = 0; i < 10; i++)
            dp[0][i] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][1] % MOD;
            dp[i][9] = dp[i - 1][8] % MOD;
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }
        int sum = 0;
        for (int i = 0; i < 9; i++)
            sum = (sum + dp[N - 1][i]) % MOD;
        System.out.println(sum % MOD);
    }
}
