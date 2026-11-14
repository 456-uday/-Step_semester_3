import java.util.Scanner;

public class Problem5_PlateStack {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;
    static int size = 0;

    static void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("push " + plate + " -> top " + top.data + ", size " + size);
    }

    static void pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return;
        }

        String plate = top.data;
        top = top.next;
        size--;

        System.out.println("pop -> " + plate + ", size " + size);
    }

    static void peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
        } else {
            System.out.println("peek -> " + top.data);
        }
    }

    static boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            if (operation.equals("push")) {
                String plate = sc.next();
                push(plate);
            } else if (operation.equals("pop")) {
                pop();
            } else if (operation.equals("peek")) {
                peek();
            } else if (operation.equals("isEmpty")) {
                System.out.println("isEmpty -> " + isEmpty());
            }
        }

        sc.close();
    }
}