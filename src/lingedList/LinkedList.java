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

    public Node kthToLast(Node first, int k) {
        Node n = first;
        int total = 1;
        while (n.next != null) {
            total++;
            n = n.next;
        }
        n = first;
        for (int i = 1; i < total - k + 1; i++) {
            n = n.next;
        }
        return n;
    }

    class Reference {
        public int count = 0;
    }

    public Node kthToLast(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }

        Node found = kthToLast(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }

        return found;
    }

    public boolean removeByNode(Node n) {
        if (n == null || n.next == null) return false;

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
