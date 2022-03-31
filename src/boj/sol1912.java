package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = Integer.parseInt(st.nextToken());

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], dp[i] + dp[i - 1]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
