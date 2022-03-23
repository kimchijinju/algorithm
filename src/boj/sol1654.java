package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] cable = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            cable[i] = Integer.parseInt(br.readLine());
            if (max < cable[i])
                max = cable[i];
        }
        long answer = 0;
        long low = 1;
        long high = max;
        while (low <= high) {
            long mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < K; i++)
                count += cable[i] / mid;

            if (count >= N) {
                low = mid + 1;
                if (answer < mid)
                    answer = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);

    }
}
