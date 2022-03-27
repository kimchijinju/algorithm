package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sol10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] card = new int[N];
        for(int i = 0 ; i < N; i++)
            card[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] cmp = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++)
            cmp[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(card);

        for(int i = 0; i < M; i++) {
            int low = 0;
            int high = N - 1;
            boolean flag = false;
            while(low <= high) {
                int mid = (low + high) / 2;
                if(cmp[i] == card[mid]) {
                    System.out.print(1 + " ");
                    flag = true;
                    break;
                }
                if(cmp[i] > card[mid])
                    low = mid + 1;
                if(cmp[i] < card[mid])
                    high = mid - 1;
            }
            if(!flag)
                System.out.print(0 + " ");
        }



    }
}
