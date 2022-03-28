package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] budget = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int high = 0;
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, budget[i]);
        }
        int total = Integer.parseInt(br.readLine());
        int low = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.min(budget[i], mid);
            }
            if (sum > total)
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println(high);
    }
}
