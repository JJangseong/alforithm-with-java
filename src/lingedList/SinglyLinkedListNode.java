package lingedList;

public class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next = null;
    SinglyLinkedListNode(int data) {
        this.data = data;
    }

    public void append(int data) {
        SinglyLinkedListNode end = new SinglyLinkedListNode(data);
        SinglyLinkedListNode n = this;

        // n 이 null 이 아닐때까지
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data) {
        SinglyLinkedListNode n = this;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {
        SinglyLinkedListNode n = this;
        while (n.next != null) {
            System.out.print(n.data + " => ");
            n = n.next;
        }
        System.out.println(n.data);
    }
}
