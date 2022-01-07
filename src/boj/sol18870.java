package boj;

import java.io.*;
import java.util.*;

public class sol18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] point = new int[N];
        for (int i = 0; i < N; i++)
            point[i] = Integer.parseInt(st.nextToken());

        int[] answer = point.clone();
        Arrays.sort(point);

        Map<Integer, Integer> pointMap = new HashMap<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (pointMap.containsKey(point[i]))
                continue;

            pointMap.put(point[i], count++);
        }

        for (int x : answer)
            bw.write(pointMap.get(x) + " ");

        bw.flush();
        bw.close();
    }
}
