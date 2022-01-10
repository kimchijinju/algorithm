package boj;

import java.io.*;
import java.util.StringTokenizer;

public class sol15651 {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[M];

        search(list, 0, N, M);
        bw.flush();
        bw.close();
    }

    private static void search(int[] list, int count, int n, int m) throws IOException {
        if (count == m) {
            for (int i : list)
                bw.write(i + " ");
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            list[count] = i + 1;
            search(list, count + 1, n, m);
        }
    }

}
