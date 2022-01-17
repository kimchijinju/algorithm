package boj;

import java.util.Scanner;

public class sol14889 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;
    static int[][] S;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        S = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                S[i][j] = scanner.nextInt();
        }

        search(0, 0);

        System.out.println(min);
    }

    private static void search(int current, int count) {
        if (count == N / 2) {
            compare();
            return;
        }

        for (int i = current; i < N; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            search(i + 1, count + 1);
            visit[i] = false;
        }
    }

    private static void compare() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    start += S[i][j];
                    start += S[j][i];
                }
                if(!visit[i] && !visit[j]){
                    link += S[i][j];
                    link += S[j][i];
                }
            }
        }
        min = Math.min(Math.abs(start - link), min);
    }

}
