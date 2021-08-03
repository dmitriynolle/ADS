package ru.gb;

public interface Decue<E> {

    void insertFirst(E value);

    void insertLast(E value);

    E removeFirst();

    E removeLast();

    boolean remove(E value);

    boolean contains(E value);

    boolean isEmpty();

    int size();

    void display();

    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
