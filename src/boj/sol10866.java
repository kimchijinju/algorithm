package boj;

import java.io.*;

public class sol10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        DeQueue queue = new DeQueue(N);
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("push_front"))
                queue.pushFront(Integer.parseInt(command[1]));
            if (command[0].equals("push_back"))
                queue.pushBack(Integer.parseInt(command[1]));
            if (command[0].equals("pop_front"))
                bw.write(queue.popFront() + "\n");
            if (command[0].equals("pop_back"))
                bw.write(queue.popBack() + "\n");
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

class DeQueue {
    int[] queue;
    int front;
    int back;
    int size;

    public DeQueue(int N) {
        queue = new int[N * 2];
        front = N / 2 - 1;
        back = N / 2;
        size = 0;
    }

    public void pushBack(int n) {
        queue[back++] = n;
        size++;
    }
    public void pushFront(int n) {
        queue[front--] = n;
        size++;
    }

    public int popFront() {
        if(size == 0)
            return -1;
        size--;
        return queue[++front];
    }
    public int popBack() {
        if(size == 0)
            return -1;
        size--;
        return queue[--back];
    }

    public int size() {
        return size;
    }

    public int empty() {
        return size == 0 ? 1 : 0;
    }

    public int front() {
        if(size == 0)
            return -1;
        return queue[front + 1];
    }
    public int back() {
        if(size == 0)
            return -1;
        return queue[back - 1];
    }
}