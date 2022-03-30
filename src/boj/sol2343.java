package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] video = new int[N];
        int high = 0;
        int low = 0;
        for (int i = 0; i < N; i++) {
            video[i] = Integer.parseInt(st.nextToken());
            high += video[i];
            low = Math.max(low, video[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            int[] blueray = new int[M];
            for(int i = 0; i < N; i++) {
                if(blueray[count] + video[i] > mid) {
                    count++;
                }
                if(count >= M)
                    break;
                blueray[count] += video[i];
            }
            if(count >= M)
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println(low);
    }
}
