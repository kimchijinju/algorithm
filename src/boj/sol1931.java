package boj;

import java.util.Arrays;
import java.util.Scanner;

public class sol1931 {
    public static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (this.end == o.end)
                return Integer.compare(this.start, o.start);

            return Integer.compare(this.end, o.end);
        }

        @Override
        public String toString() {
            return start + " " + end + "\n";
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Time[] times = new Time[N];
        for (int i = 0; i < N; i++)
            times[i] = new Time(scanner.nextInt(), scanner.nextInt());

        Arrays.sort(times);

        int answer = 1;
        int current = 0;
        for (int i = 1; i < N; i++) {
            if (times[i].start >= times[current].end) {
                current = i;
                answer++;
            }
        }
        System.out.println(answer);
    }

}
