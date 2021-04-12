package queue;


public class Main {
    public static void main(String[] args) {
        Queue<Integer> s = new Queue<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);

        System.out.println(s.remove());
        System.out.println(s.remove());
        System.out.println(s.peek());
        System.out.println(s.remove());
        System.out.println(s.isEmpty());
        System.out.println(s.remove());
        System.out.println(s.isEmpty());
    }
}
