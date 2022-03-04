package boj;

import java.io.*;

public class sol10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        myStack stack = new myStack();
        for(int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            if(command[0].equals("push"))
                stack.push(Integer.parseInt(command[1]));
            if(command[0].equals("pop"))
                bw.write(stack.pop() + "\n");
            if(command[0].equals("size"))
                bw.write(stack.size() + "\n");
            if(command[0].equals("empty"))
                bw.write(stack.empty() + "\n");
            if(command[0].equals("top"))
                bw.write(stack.top() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class myList {
    myList next;
    int value;
}

class myStack {
    private myList head;
    private int size;

    public void push(int n) {
        if(size == 0) {
            head = new myList();
            head.value = n;
            size = 1;
            return ;
        }
        myList currentNode = new myList();
        currentNode.value = head.value;
        currentNode.next = head.next;

        myList pushNode = new myList();
        pushNode.value = n;
        head = pushNode;
        head.next = currentNode;
        size++;
    }

    public int size() {
        return this.size;
    }

    public int top() {
        if(empty() == 1)
            return -1;
        return head.value;
    }

    public int empty() {
        return size == 0 ? 1 : 0;
    }

    public int pop() {
        if(size == 0)
            return -1;

        int returnValue = head.value;
        head = head.next;
        size--;
        return returnValue;
    }
}
