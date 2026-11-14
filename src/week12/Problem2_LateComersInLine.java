import java.util.Scanner;

public class Problem2_LateComersInLine {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    static Node addLast(Node head, String name) {
        Node newNode = new Node(name);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    static void printLine(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;

        System.out.println("Enter starting number of students:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            head = addLast(head, sc.next());
        }

        System.out.println("Enter number of operations:");
        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {
            String operation = sc.next();
            String name = sc.next();

            if (operation.equals("addFirst")) {
                head = addFirst(head, name);
            } else if (operation.equals("addLast")) {
                head = addLast(head, name);
            }
        }

        printLine(head);

        sc.close();
    }
}