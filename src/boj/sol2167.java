package boj;

import java.util.Scanner;

public class sol2167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int K = sc.nextInt();
        for (int k = 1; k <= K; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int answer = 0;
            for (int l = i; l < x; l++) {
                for (int m = j; m <= y; m++) {
                    answer += arr[i][j];
                }
            }
            System.out.println(answer);
        }

    }
}
