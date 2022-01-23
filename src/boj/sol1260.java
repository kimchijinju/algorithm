package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol1260 {

    static int[][] map;
    static boolean[] visit;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        map = new int[N][N];

        visit = new boolean[N];

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            map[x][y] = map[y][x] = 1;
        }
        dfs(V - 1);

        visit = new boolean[N];
        System.out.println();
        bfs(V - 1);
    }

    public static void bfs(int v) {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(v);
        visit[v] = true;

        while (!bfs.isEmpty()) {
            int n = bfs.poll();
            System.out.print(n + 1 + " ");

            for (int i = 0; i < N; i++) {
                if (map[n][i] == 1 && !visit[i]) {
                    bfs.add(i);
                    visit[i] = true;
                }
            }
        }

    }

    public static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + 1 + " ");
        for (int i = 0; i < N; i++) {
            if (map[v][i] == 1 && !visit[i])
                dfs(i);
        }

    }
}
