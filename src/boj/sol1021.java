package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sol1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] seq = new int[M];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++)
            queue.addLast(i + 1);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < M; i++) {
            int index = queue.indexOf(seq[i]);
            if (index > queue.size() / 2) {
                while (queue.getFirst() != seq[i]) {
                    queue.addFirst(queue.removeLast());
                    count++;
                }
            } else {
                while (queue.getFirst() != seq[i]) {
                    queue.addLast(queue.removeFirst());
                    count++;
                }
            }
            queue.removeFirst();
        }
        System.out.println(count);
    }
}
