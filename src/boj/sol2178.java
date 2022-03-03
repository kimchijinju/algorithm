package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sol2178 {

    static class Node {
        int y;
        int x;
        int count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++)
                maze[i][j] = Integer.parseInt(str[j]);
        }
        System.out.println(bfs(maze, visit, N, M));
    }

    private static int bfs(int[][] maze, boolean[][] visit, int N, int M) {
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(0, 0, 1);
        queue.add(start);
        while (!queue.isEmpty()) {
            Node next = queue.poll();
            visit[next.y][next.x] = true;
            if (next.y == N - 1 && next.x == M - 1)
                return next.count;

            if (next.y + 1 < N && maze[next.y + 1][next.x] == 1 && !visit[next.y + 1][next.x]) {
                queue.add(new Node(next.y + 1, next.x, next.count + 1));
                visit[next.y + 1][next.x] = true;
            }

            if (next.y - 1 >= 0 && maze[next.y - 1][next.x] == 1 && !visit[next.y - 1][next.x]) {
                queue.add(new Node(next.y - 1, next.x, next.count + 1));
                visit[next.y - 1][next.x] = true;
            }

            if (next.x + 1 < M && maze[next.y][next.x + 1] == 1 && !visit[next.y][next.x + 1]) {
                queue.add(new Node(next.y, next.x + 1, next.count + 1));
                visit[next.y][next.x + 1] = true;
            }

            if (next.x - 1 >= 0 && maze[next.y][next.x - 1] == 1 && !visit[next.y][next.x - 1]) {
                queue.add(new Node(next.y, next.x - 1, next.count + 1));
                visit[next.y][next.x - 1] = true;
            }
        }
        return 0;
    }
}
