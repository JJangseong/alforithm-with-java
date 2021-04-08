package lingedList;

import java.util.Stack;

public class LinkedListUtils {

    /**
     * 뒤에서 k 번째 Node를 반환하는 함수
     * @param first
     * @param k
     * @return
     */
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

    /**
     * 뒤에서 k 번째 Node를 반환하는 함수 ( 재귀함수 버전 )
     * @param n
     * @param k
     * @param r
     * @return
     */
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

    /**
     *  Node로 LinkedList에서 삭제 함수
     * @param n
     * @return
     */
    public static boolean removeByNode(LinkedList.Node n) {
        if (n == null || n.next == null) return false;

        LinkedList.Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    /**
     * x 값 기준으로 작으면 왼쪽 크면 오른쪽으로 정렬하는 함수
     * @param n
     * @param x
     * @return
     */
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

    /**
     *  x 값 기준으로 작으면 왼쪽 크면 오른쪽으로 정렬하는 함수 ( 지역변수 줄인 버전 )
     * @param n
     * @param x
     * @return
     */
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

    /**
     * 두개의 LinkedList를 각각 반전후 합친 값을 다시 LinkedList 로 만드는 함수
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * 1 2 3 2 1 처럼 뒤집어도 안뒤집어도 같은지를 비교하는 함수
     * @param head
     * @return
     */
    public static boolean isPalindrome(LinkedList.Node head) {
        LinkedList.Node reversed = reverseAndClone(head);

        return isEqual(head, reversed);
    }

    public static boolean isPalindromeV2(LinkedList.Node head) {
        LinkedList.Node fast = head;
        LinkedList.Node slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int c = stack.pop();

            if (slow.data != c) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static boolean isPalindromeV3(LinkedList.Node head) {
        int length = getListLength(head);
        StorageByPalindrome storage = isPalindromeRecursive(head, length); 
        return storage.result;
    }

    public static StorageByPalindrome isPalindromeRecursive(LinkedList.Node head, int length) {
        if (head == null || length <= 0) {
            return new StorageByPalindrome(head, true);
        } else if (length == 1) {
            return new StorageByPalindrome(head.next, true);
        }

        StorageByPalindrome storage = isPalindromeRecursive(head.next, length - 1);

        if (!storage.result || storage.node == null) {
            return storage;
        }

        storage.result = (head.data == storage.node.data);

        storage.node = storage.node.next;
        return storage;
    }

    /**
     * 노드가 같은지 비교하는 함수
     * @param one
     * @param two
     * @return
     */
    public static boolean isEqual(LinkedList.Node one , LinkedList.Node two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    /**
     * 노드를 대칭으로 뒤집는 함수
     * @param node
     * @return
     */
    public static LinkedList.Node reverseAndClone(LinkedList.Node node) {
        LinkedList.Node head = null;
        while (node != null) {
            LinkedList.Node n = new LinkedList.Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    /**
     * 두 노드의 교차점을 찾아서 노드를 반환 하는 함수
     * @param l1
     * @param l2
     * @return
     */
    public static LinkedList.Node getIntersection(LinkedList.Node l1, LinkedList.Node l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if (len1 > len2) {
            l1 = l1.get(len1 - len2);
        } else if (len1 < len2) {
            l2 = l2.get(len2 - len1);
        }

        while (l1 != null && l2 != null) {
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }
    
}

class Storage {
    int carry = 0;
    LinkedList.Node result = null;
}

class StorageByPalindrome {
    public LinkedList.Node node;
    public boolean result;

    StorageByPalindrome(LinkedList.Node n, boolean r) {
        node = n;
        result = r;
    }
}

