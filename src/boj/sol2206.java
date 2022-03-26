package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sol2206 {

    static class Node {
        int y;
        int x;
        int count;
        int breakWall;

        public Node(int y, int x, int count, int breakWall) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.breakWall = breakWall;
        }
    }

    static int N;
    static int M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        answer = -1;
        bfs(map);
        System.out.println(answer);
    }

    private static void bfs(int[][] map) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[N][M][2];
        queue.add(new Node(0, 0, 1, 0));
        visit[0][0][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.y == N - 1 && node.x == M - 1) {
                answer = node.count;
                return;
            }

            if (node.y + 1 < N && map[node.y + 1][node.x] == 1 && node.breakWall == 0) {
                visit[node.y + 1][node.x][1] = true;
                queue.add(new Node(node.y + 1, node.x, node.count + 1, 1));
            }

            if (node.y - 1 >= 0 && map[node.y - 1][node.x] == 1 && node.breakWall == 0) {
                visit[node.y - 1][node.x][1] = true;
                queue.add(new Node(node.y - 1, node.x, node.count + 1, 1));
            }

            if (node.x + 1 < M && map[node.y][node.x + 1] == 1 && node.breakWall == 0) {
                visit[node.y][node.x + 1][node.breakWall] = true;
                queue.add(new Node(node.y, node.x + 1, node.count + 1, 1));
            }

            if (node.x - 1 >= 0 && map[node.y][node.x - 1] == 1 && node.breakWall == 0) {
                visit[node.y][node.x - 1][node.breakWall] = true;
                queue.add(new Node(node.y, node.x - 1, node.count + 1, 1));
            }

            if (node.y + 1 < N && map[node.y + 1][node.x] == 0 && !visit[node.y + 1][node.x][node.breakWall]) {
                visit[node.y + 1][node.x][node.breakWall] = true;
                queue.add(new Node(node.y + 1, node.x, node.count + 1, node.breakWall));
            }

            if (node.y - 1 >= 0 && map[node.y - 1][node.x] == 0 && !visit[node.y - 1][node.x][node.breakWall]) {
                visit[node.y - 1][node.x][node.breakWall] = true;
                queue.add(new Node(node.y - 1, node.x, node.count + 1, node.breakWall));
            }

            if (node.x + 1 < M && map[node.y][node.x + 1] == 0 && !visit[node.y][node.x + 1][node.breakWall]) {
                visit[node.y][node.x + 1][node.breakWall] = true;
                queue.add(new Node(node.y, node.x + 1, node.count + 1, node.breakWall));
            }

            if (node.x - 1 >= 0 && map[node.y][node.x - 1] == 0 && !visit[node.y][node.x - 1][node.breakWall]) {
                visit[node.y][node.x - 1][node.breakWall] = true;
                queue.add(new Node(node.y, node.x - 1, node.count + 1, node.breakWall));
            }
        }
    }

}
