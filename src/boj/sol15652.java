package boj;

import java.io.*;
import java.util.StringTokenizer;

public class sol15652 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] list = new int[M];
        boolean[] visit = new boolean[N];

        search(visit, list, 0, 0);
        bw.flush();
        bw.close();
    }

    private static void search(boolean[] visit, int[] list, int count, int o) throws IOException {
        if (count == M) {
            for (int i : list)
                bw.write(i + " ");
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;
            list[count] = i + 1;
            search(visit, list, count + 1, i);
            visit[o] = true;
        }
        for(int i = o + 1; i < N; i++) {
            visit[i] = false;
        }
    }
}
