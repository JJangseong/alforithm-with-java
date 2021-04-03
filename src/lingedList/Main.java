package lingedList;

public class Main {

    public static void main(String[] args) {
        LinkedList n = new LinkedList();
        n.append(2);
        n.append(3);
        n.append(4);

        n.delete(3);
        n.retrieve();
    }
}
