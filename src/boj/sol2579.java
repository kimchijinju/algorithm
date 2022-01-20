package boj;

import java.util.Scanner;

public class sol2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int N = scanner.nextInt();

        int[] stair = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++)
            stair[i] = scanner.nextInt();

        switch(N) {
            case 1:
                System.out.println(stair[0]);
                return;
            case 2:
                System.out.println(stair[0] + stair[1]);
                return;
        }

        dp[0] = stair[0];
        dp[1] = Math.max(stair[0] + stair[1],stair[1]);
        dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

        for(int i = 3; i < N; i++)
            dp[i] = Math.max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i]);

        System.out.println(dp[N - 1]);

    }
}
