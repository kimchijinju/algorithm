package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sol7576 {

    static int answer;

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
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] tomato = new int[N][M];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(str[j]);
                if(tomato[i][j] == 1) {
                    Node ripeTomato = new Node(i, j, 0);
                    queue.add(ripeTomato);
                }
            }
        }
        answer = 0;
        bfs(tomato,queue, N, M);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomato[i][j] == 0) {
                    System.out.println(-1);
                    return ;
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int[][] tomato, Queue<Node> queue , int N, int M) {
        int flag = 0;
        while (!queue.isEmpty()) {
            Node next = queue.poll();
            if(flag != next.count) {
                answer++;
                flag = next.count;
            }
            if (next.y + 1 < N && tomato[next.y + 1][next.x] == 0) {
                tomato[next.y + 1][next.x] = 1;
                queue.add(new Node(next.y + 1, next.x, next.count + 1));
            }

            if (next.y - 1 >= 0 && tomato[next.y - 1][next.x] == 0) {
                tomato[next.y - 1][next.x] = 1;
                queue.add(new Node(next.y - 1, next.x, next.count + 1));
            }

            if (next.x + 1 < M && tomato[next.y][next.x + 1] == 0) {
                tomato[next.y][next.x + 1] = 1;
                queue.add(new Node(next.y, next.x + 1, next.count + 1));
            }

            if (next.x - 1 >= 0 && tomato[next.y][next.x - 1] == 0) {
                tomato[next.y][next.x - 1] = 1;
                queue.add(new Node(next.y, next.x - 1, next.count + 1));
            }
        }
        return 0;
    }
}
