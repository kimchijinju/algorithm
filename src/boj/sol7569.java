package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sol7569 {

    static int answer;

    static class Node {
        int z;
        int y;
        int x;
        int count;

        public Node(int z, int y, int x, int count) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] tomato = new int[H][N][M];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] str = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(str[k]);
                    if (tomato[i][j][k] == 1) {
                        Node ripeTomato = new Node(i, j, k, 0);
                        queue.add(ripeTomato);
                    }
                }
            }
        }
        answer = 0;
        bfs(tomato, queue, H, N, M);
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int[][][] tomato, Queue<Node> queue, int H, int N, int M) {
        int flag = 0;
        while (!queue.isEmpty()) {
            Node next = queue.poll();
            if (flag != next.count) {
                answer++;
                flag = next.count;
            }
            if (next.z + 1 < H && tomato[next.z + 1][next.y][next.x] == 0) {
                tomato[next.z + 1][next.y][next.x] = 1;
                queue.add(new Node(next.z + 1, next.y, next.x, next.count + 1));
            }
            if (next.z - 1 >= 0 && tomato[next.z - 1][next.y][next.x] == 0) {
                tomato[next.z - 1][next.y][next.x] = 1;
                queue.add(new Node(next.z - 1, next.y, next.x, next.count + 1));
            }
            if (next.y + 1 < N && tomato[next.z][next.y + 1][next.x] == 0) {
                tomato[next.z][next.y + 1][next.x] = 1;
                queue.add(new Node(next.z, next.y + 1, next.x, next.count + 1));
            }

            if (next.y - 1 >= 0 && tomato[next.z][next.y - 1][next.x] == 0) {
                tomato[next.z][next.y - 1][next.x] = 1;
                queue.add(new Node(next.z, next.y - 1, next.x, next.count + 1));
            }

            if (next.x + 1 < M && tomato[next.z][next.y][next.x + 1] == 0) {
                tomato[next.z][next.y][next.x + 1] = 1;
                queue.add(new Node(next.z, next.y, next.x + 1, next.count + 1));
            }

            if (next.x - 1 >= 0 && tomato[next.z][next.y][next.x - 1] == 0) {
                tomato[next.z][next.y][next.x - 1] = 1;
                queue.add(new Node(next.z, next.y, next.x - 1, next.count + 1));
            }
        }
        return 0;
    }
}

