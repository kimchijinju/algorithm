package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class sol5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        String command = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), ",|[]");

        for (int i = 0; i < n; i++)
            deque.push(Integer.valueOf(st.nextToken()));

        boolean reverse = false;
        int deleteCount = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'R')
                reverse = !reverse;

            if (command.charAt(i) == 'D') {
                if (reverse)
                    deque.pollFirst();
                else
                    deque.pollLast();
                deleteCount++;
            }
            if (deleteCount > n) {
                System.out.println("error");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            if (i > 0)
                sb.append(",");
            sb.append(reverse ? deque.pollFirst() : deque.pollLast());
        }
        sb.append("]");
        System.out.println(sb);
    }
}
