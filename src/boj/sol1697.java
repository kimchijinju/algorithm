package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol1697 {
    static class Node {
        int x;
        int count;

        public Node(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        boolean[] visit = new boolean[100001];
        if (N == K) {
            System.out.println(0);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        visit[N] = true;
        queue.add(new Node(N - 1, 1));
        queue.add(new Node(N + 1, 1));
        queue.add(new Node(2 * N, 1));
        while (!queue.isEmpty()) {
            Node next = queue.poll();
            if(next.x < 0)
                continue;
            if (next.x == K) {
                System.out.println(next.count);
                return;
            }
            if (next.x - 1 >= 0 && next.x - 1 <= 100000 && !visit[next.x - 1]) {
                queue.add(new Node(next.x - 1, next.count + 1));
                visit[next.x - 1] = true;
            }
            if (next.x + 1 <= 100000 && !visit[next.x + 1]) {
                queue.add(new Node(next.x + 1, next.count + 1));
                visit[next.x + 1] = true;
            }
            if (2 * next.x <= 100000 && !visit[2 * next.x]) {
                queue.add(new Node(2 * next.x, next.count + 1));
                visit[2 * next.x] = true;
            }
        }
    }
}
