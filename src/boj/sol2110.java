package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sol2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] x = new int[N];
        int high = 0;
        int low = 1;
        for(int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, x[i] - 1);
        }
        Arrays.sort(x);
        int answer = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            int count = 1;
            int previous = 0;
            for(int i = 0; i < N; i++) {
                if(x[i] - x[previous] >= mid) {
                    count++;
                    previous = i;
                }
            }
            if(count >= C) {
                low = mid + 1;
                answer = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
