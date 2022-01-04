package boj;

import java.util.Arrays;
import java.util.Scanner;

public class sol11650 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++)
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());

        Arrays.sort(points);

        for (Point point : points)
            System.out.println(point);

    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x > o.x)
                return 1;

            if (this.x == o.x) {
                if (this.y > o.y)
                    return 1;
            }

            return -1;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

}

