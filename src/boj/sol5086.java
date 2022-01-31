package boj;

import java.util.Scanner;

public class sol5086 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            if(i == 0 && j == 0)
                break;
            if (j % i == 0) {
                System.out.println("factor");
                continue;
            }
            if (i % j == 0) {
                System.out.println("multiple");
                continue;
            }
            System.out.println("neither");
        }
    }

}
