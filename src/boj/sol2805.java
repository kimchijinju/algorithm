package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sol2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int high = 0;
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(high < tree[i])
                high = tree[i];
        }
        int answer = 0;
        int low = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            long cut = 0;
            for(int i = 0; i < N; i++) {
                if(tree[i] - mid > 0)
                    cut += tree[i] - mid;
            }
            if (cut >= M) {
                low = mid + 1;
                if (answer < mid)
                    answer = mid;
            } else
                high = mid - 1;
        }
        System.out.println(answer);
    }
}
