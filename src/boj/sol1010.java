package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            double answer = factorial(M) / (factorial(M - N) * factorial(N));
            System.out.printf("%.0f\n", answer);
        }

    }
    public static double factorial(int n) {
        if(n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
