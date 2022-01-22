package boj;

import java.util.Arrays;
import java.util.Scanner;

public class sol1932 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] triangle = new int[n][n];
        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        answer[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if(j == 0) {
                    answer[i][j] = answer[i - 1][j] + triangle[i][j];
                    continue;
                }
                answer[i][j] = Math.max(answer[i - 1][j], answer[i - 1][j - 1]) + triangle[i][j];
            }
        }

        Arrays.sort(answer[n - 1]);
        System.out.println(answer[n - 1][n - 1]);

    }
}