package boj;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class sol10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            card[i] = n;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        int[] num = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(card);

        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N - 1;
            int mid = (start + end) / 2;
            boolean flag = false;
            while (end - start >= 0) {
                if (num[i] == card[mid]) {
                    bw.write(map.getOrDefault(card[mid], 0) + " ");
                    flag = true;
                    break;
                } else if (num[i] < card[mid]) {
                    end = mid - 1;
                } else if (num[i] > card[mid]) {
                    start = mid + 1;
                }
                mid = (start + end) / 2;
            }
            if(!flag)
                bw.write(0 + " ");
        }
        bw.flush();
        bw.close();
    }
}
