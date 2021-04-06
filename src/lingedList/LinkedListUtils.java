package lingedList;

public class LinkedListUtils {

    public static LinkedList.Node kthToLast(LinkedList.Node first, int k) {
        LinkedList.Node n = first;
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

    public static LinkedList.Node kthToLast(LinkedList.Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }

        LinkedList.Node found = kthToLast(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }

        return found;
    }

    public static boolean removeByNode(LinkedList.Node n) {
        if (n == null || n.next == null) return false;

        LinkedList.Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static LinkedList.Node Partition(LinkedList.Node n, int x) {
        LinkedList.Node s1 = null;
        LinkedList.Node e1 = null;
        LinkedList.Node s2 = null;
        LinkedList.Node e2 = null;

        while (n != null) {
            LinkedList.Node next = n.next;
            n.next = null;
            if (n.data < x) {
                if (s1 == null) {
                    s1 = n;
                    e1 = s1;
                } else {
                    e1.next = n;
                    e1 = n;
                }
            } else {
                if (s2 == null) {
                    s2 = n;
                    e2 = s2;
                } else {
                    e2.next = n;
                    e2 = n;
                }
            }
            n = next;
        }
        if (s1 == null) {
            return s2;
        }
        e1.next = s2;
        return s1;
    }

    public static LinkedList.Node PartitionV2(LinkedList.Node n, int x) {
        LinkedList.Node head = n;
        LinkedList.Node tail = n;

        while (n != null) {
            LinkedList.Node next = n.next;
            if (n.data < x) {
                n.next = head;
                head = n;
            } else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null;

        return head;
    }

    public static LinkedList.Node sumeLists(LinkedList.Node l1, LinkedList.Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedList.Node result = new LinkedList.Node();
        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }

        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;

        if (l1 != null || l2 != null) {
            result = sumeLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
        }
        return result;
    }

    public static LinkedList.Node sumLists(LinkedList.Node l1, LinkedList.Node l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if (len1 < len2) {
            l1 = LPadList(l1, len2 - len1);
        } else {
            l2 = LPadList(l2, len1 - len2);
        }

        Storage storage = addLists(l1, l2);
        if (storage.carry != 0) {
            storage.result = insertBefore(storage.result, storage.carry);
        }
        return storage.result;
    }

    private static Storage addLists(LinkedList.Node l1, LinkedList.Node l2) {
        if (l1 == null && l2 == null) {
            Storage storage = new Storage();
            return storage;
        }
        Storage storage = addLists(l1.next, l2.next);
        int value = storage.carry + l1.data + l2.data;
        int data = value % 10;
        storage.result = insertBefore(storage.result, data);
        storage.carry = value / 10;

        return storage;
    }

    /**
     * LinkedList 길이 반환하는 함수
     *
     * @param l
     * @return
     */
    public static int getListLength(LinkedList.Node l) {
        int total = 0;
        while (l != null) {
            total++;
            l = l.next;
        }
        return total;
    }

    /**
     * LinkedList 앞에 데이터를 넣어주는 함수
     *
     * @param node
     * @param data
     * @return
     */
    public static LinkedList.Node insertBefore(LinkedList.Node node, int data) {
        LinkedList.Node before = new LinkedList.Node(data);
        if (node != null) {
            before.next = node;
        }
        return before;
    }

    /**
     * LinkedList 빈곳에 0으로 채워주는 함수
     *
     * @param l
     * @param length
     * @return
     */
    public static LinkedList.Node LPadList(LinkedList.Node l, int length) {
        LinkedList.Node head = l;
        for (int i = 0; i < length; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }
}

class Storage {
    int carry = 0;
    LinkedList.Node result = null;
}
