package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sol7562 {

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
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            String[] curPoint = br.readLine().split(" ");
            String[] movingPoint = br.readLine().split(" ");
            int curY = Integer.parseInt(curPoint[0]);
            int curX = Integer.parseInt(curPoint[1]);
            int moveY = Integer.parseInt(movingPoint[0]);
            int moveX = Integer.parseInt(movingPoint[1]);
            bfs(I, curY, curX, moveY, moveX);

        }

    }

    private static void bfs(int I, int curY, int curX, int moveY, int moveX) {
        int[][] map = new int[I][I];
        boolean[][] visit = new boolean[I][I];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(curY, curX, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.y == moveY && node.x == moveX) {
                System.out.println(node.count);
                return;
            }

            if (node.y + 1 < I && node.x - 2 >= 0 && !visit[node.y + 1][node.x - 2]) {
                queue.add(new Node(node.y + 1, node.x - 2, node.count + 1));
                visit[node.y + 1][node.x - 2] = true;
            }
            if (node.y + 2 < I && node.x - 1 >= 0 && !visit[node.y + 2][node.x - 1]) {
                queue.add(new Node(node.y + 2, node.x - 1, node.count + 1));
                visit[node.y + 2][node.x - 1] = true;
            }
            if (node.y + 1 < I && node.x + 2 < I && !visit[node.y + 1][node.x + 2]) {
                queue.add(new Node(node.y + 1, node.x + 2, node.count + 1));
                visit[node.y + 1][node.x + 2] = true;
            }
            if (node.y + 2 < I && node.x + 1 < I && !visit[node.y + 2][node.x + 1]) {
                queue.add(new Node(node.y + 2, node.x + 1, node.count + 1));
                visit[node.y + 2][node.x + 1] = true;
            }
            if (node.y - 1 >= 0 && node.x - 2 >= 0 && !visit[node.y - 1][node.x - 2]) {
                queue.add(new Node(node.y - 1, node.x - 2, node.count + 1));
                visit[node.y - 1][node.x - 2] = true;
            }
            if (node.y - 2 >= 0 && node.x - 1 >= 0 && !visit[node.y - 2][node.x - 1]) {
                queue.add(new Node(node.y - 2, node.x - 1, node.count + 1));
                visit[node.y - 2][node.x - 1] = true;
            }
            if (node.y - 1 >= 0 && node.x + 2 < I && !visit[node.y - 1][node.x + 2]) {
                queue.add(new Node(node.y - 1, node.x + 2, node.count + 1));
                visit[node.y - 1][node.x + 2] = true;
            }
            if (node.y - 2 >= 0 && node.x + 1 < I && !visit[node.y - 2][node.x + 1]) {
                queue.add(new Node(node.y - 2, node.x + 1, node.count + 1));
                visit[node.y - 2][node.x + 1] = true;
            }
        }
    }
}