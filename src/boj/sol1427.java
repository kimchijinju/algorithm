package boj;

import java.util.Arrays;
import java.util.Scanner;

public class sol1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();

        int[] answer = toArray(N);
        Arrays.sort(answer);

        for(int i = answer.length - 1; i >= 0; i--)
            System.out.print(answer[i]);
    }

    private static int[] toArray(String n) {
        int[] sortArr = new int[n.length()];
        int sortNumber = Integer.parseInt(n);

        int i = 0;
        while(sortNumber > 0) {
            sortArr[i] = sortNumber % 10;
            sortNumber /= 10;
            i++;
        }
        return sortArr;
    }
}
