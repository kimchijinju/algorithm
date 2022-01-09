package boj;
import java.util.Scanner;

public class sol10870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(fibonacci(sc.nextInt()));
    }

    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibonacci(n -1) + fibonacci(n - 2) ;

    }

}
