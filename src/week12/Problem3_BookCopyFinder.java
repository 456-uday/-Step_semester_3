import java.util.Scanner;

public class Problem3_BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static String find(Node head, String id) {
        Node current = head;
        int position = 1;
        int firstPosition = -1;
        int copies = 0;

        while (current != null) {
            if (current.data.equals(id)) {
                if (firstPosition == -1) {
                    firstPosition = position;
                }
                copies++;
            }

            current = current.next;
            position++;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position " + firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;
        Node current = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String bookId = sc.next();
            Node newNode = new Node(bookId);

            if (head == null) {
                head = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }

        String id = sc.next();

        System.out.println(find(head, id));

        sc.close();
    }
}