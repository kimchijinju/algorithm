package boj;

import java.util.Scanner;

public class sol1463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        if (X == 0 || X == 1) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[X + 1];

        for (int i = 2; i < X + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
        }

        System.out.println(dp[X]);


    }
}
