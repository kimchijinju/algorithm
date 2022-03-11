package boj;

import java.util.Scanner;

public class sol11866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        myQueue queue = new myQueue(100000);
        StringBuilder sb = new StringBuilder();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        for(int i = 0; i < N; i++) {
            queue.push(i + 1);
        }
        int loop = 1;
        sb.append("<");
        while(queue.empty() == 0) {
            if(loop == K) {
                sb.append(queue.pop()).append(", ");
                loop = 1;
                continue;
            }
            queue.push(queue.pop());
            loop++;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
