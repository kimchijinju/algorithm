package boj;

import java.util.Scanner;

public class sol1436 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int index = 1;
        int seriesNumber = 666;
        while (index < N) {
            seriesNumber++;

            if (has666(seriesNumber)) {
                index++;
            }
        }

        System.out.println(seriesNumber);
    }

    private static boolean has666(int i) {
        return String.valueOf(i).contains("666");
    }
}
