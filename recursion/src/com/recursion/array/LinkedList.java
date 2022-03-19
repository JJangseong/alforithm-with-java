package com.recursion.array;

/**
 * Created by marathoner on 2022/03/19
 */
public class LinkedList<T> {
    public static class Node<T> {
        public T data;
        public Node<T> nextNode;
        public Node<T> prevNode;
    }

    private final Node<T> head;
    private int size;

    public LinkedList() {
        this.size = 0;
        this.head = new Node<>();
        this.head.prevNode = null;
        this.head.nextNode = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;
        Node<T> node = this.get(size);
        node.nextNode = newNode;
        newNode.prevNode = node;
        size++;
    }

    public Node<T> get(int index) {
        if(index > this.size) throw new IndexOutOfBoundsException();

        Node<T> node = this.head;
        int count = 0;
        while (node.nextNode != null) {
            node = node.nextNode;
            if (count == index) return node;
            count++;
        }
        return node;
    }

    public void remove(int index) {
        if(index > this.size) throw new IndexOutOfBoundsException();

        if(index == 0) {
            Node<T> deleteNode = this.head.nextNode;
            Node<T> nextNode = deleteNode.nextNode;
            this.head.nextNode = nextNode;
            nextNode.prevNode = this.head;
            return;
        }

        if(index == size) {
            Node<T> deleteNode = this.get(index);
            deleteNode.prevNode.nextNode = null;
            return;
        }
        Node<T> node = this.get(index-1);
        Node<T> nextNode = this.get(index+1);
        node.nextNode = nextNode;
        nextNode.prevNode = node;
    }

    public int getSize() {
        return this.size;
    }

    public void print() {
        Node<T> node = this.head;
        System.out.print("[ ");
        while (node.nextNode != null) {
            node = node.nextNode;
            System.out.print(node.data + " ");

        }
        System.out.println("]");
    }

}
