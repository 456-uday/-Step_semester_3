import java.util.Scanner;

public class Problem4_CancelBooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node removeFirst(Node head, String booking) {

        if (head == null) {
            return head;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data.equals(booking)) {
                current.next = current.next.next;
                return head;
            }

            current = current.next;
        }

        return head;
    }

    static void printBookings(Node head) {
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
        Node current = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.next());

            if (head == null) {
                head = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }

        String booking = sc.next();

        boolean found = false;
        Node temp = head;

        while (temp != null) {
            if (temp.data.equals(booking)) {
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println(booking + " not found");
            printBookings(head);
        } else {
            head = removeFirst(head, booking);
            printBookings(head);
        }

        sc.close();
    }
}