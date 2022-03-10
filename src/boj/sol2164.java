package boj;

import java.util.Scanner;

public class sol2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        myQueue queue = new myQueue(1000000);
        for(int i = 0; i < N; i++)
            queue.push(i + 1);
        while(queue.size() != 1) {
            queue.pop();
            queue.push(queue.pop());
        }
        System.out.println(queue.front());
    }
}
