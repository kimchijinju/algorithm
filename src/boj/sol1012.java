package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol1012 {
    static boolean search;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < T; loop++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] farm = new int[N][M];
            boolean[][] visit = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1;
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    search = false;
                    if (farm[i][j] == 1 && !visit[i][j]) {
                        dfs(i, j, farm, visit);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int y, int x, int[][] farm, boolean[][] visit) {
        visit[y][x] = true;
        if (y + 1 < farm.length && farm[y + 1][x] == 1 && !visit[y + 1][x])
            dfs(y + 1, x, farm, visit);
        if (y - 1 >= 0 && farm[y - 1][x] == 1 && !visit[y - 1][x])
            dfs(y - 1, x, farm, visit);
        if (x + 1 < farm[y].length && farm[y][x + 1] == 1 && !visit[y][x + 1])
            dfs(y, x + 1, farm, visit);
        if (x - 1 >= 0 && farm[y][x - 1] == 1 && !visit[y][x - 1])
            dfs(y, x - 1, farm, visit);
    }
}