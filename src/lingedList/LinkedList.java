package lingedList;

public class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next  = null;
    }

    LinkedList() {
        header = new Node();
    }

    public void append(int data) {
        Node end = new Node();
        end.data = data;
        Node n = header;

        // n 이 null 이 아닐때까지
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " => ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    /**
     * 중복 제거
     */
    public void removeDups() {
        Node n = header;
        while (n != null && n.next != null) {
            Node r =n;
            while (r.next != null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                }else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}
