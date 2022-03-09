package boj;

import java.io.*;

public class sol18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        myQueue queue = new myQueue(N);
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("push"))
                queue.push(Integer.parseInt(command[1]));
            if (command[0].equals("pop"))
                bw.write(queue.pop() + "\n");
            if (command[0].equals("size"))
                bw.write(queue.size() + "\n");
            if (command[0].equals("empty"))
                bw.write(queue.empty() + "\n");
            if (command[0].equals("front"))
                bw.write(queue.front() + "\n");
            if (command[0].equals("back"))
                bw.write(queue.back() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class myQueue {
    int[] queue;
    int front;
    int back;

    public myQueue(int N) {
        queue = new int[N + 1];
        front = 0;
        back = 0;
    }

    public void push(int n) {
        queue[back++] = n;
    }

    public int pop() {
        if(front >= back)
            return -1;
        return queue[front++];
    }

    public int size() {
        return back - front;
    }

    public int empty() {
        return front == back ? 1 : 0;
    }

    public int front() {
        if(front == back)
            return -1;
        return queue[front];
    }
    public int back() {
        if(front == back)
            return -1;
        return queue[back - 1];
    }
}
