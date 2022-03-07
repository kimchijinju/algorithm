package boj;

import java.util.Scanner;

public class sol1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        myStack stack = new myStack();
        StringBuilder sb = new StringBuilder();
        int n = scanner.nextInt();
        int[] check = new int[n];
        int[] pop = new int[n];

        int count = 1;
        for (int i = 0; i < n; i++) {
            check[i] = scanner.nextInt();

            while (count <= check[i]) {
                stack.push(count++);
                sb.append("+\n");
            }
            if (stack.top() == check[i]) {
                pop[i] = stack.pop();
                sb.append("-\n");
            }
        }
        for (int i = 0; i < n; i++) {
            if (pop[i] != check[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
