package boj;

import java.util.Scanner;

public class sol9095 {
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            count = 0;
            int n = scanner.nextInt();
            dp(1, n);
            dp(2, n);
            dp(3, n);
            System.out.println(count);
        }
    }

    private static void dp(int i, int n) {
        if (i > n)
            return;
        if (i == n) {
            count++;
            return;
        }
        dp(i + 1, n);
        dp(i + 2, n);
        dp(i + 3, n);
    }
}
