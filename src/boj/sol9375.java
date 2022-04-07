package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class sol9375 {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(solution(n));
        }
    }

    private static int solution(int n) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            String wear = st.nextToken();
            map.put(wear, map.getOrDefault(wear, 0) + 1);
        }
        int result = 1;
        for(int a : map.values())
            result *= a + 1;
        return result - 1;
    }
}
