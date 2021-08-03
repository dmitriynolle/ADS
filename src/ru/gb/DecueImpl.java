package ru.gb;

import java.util.Iterator;

public class DecueImpl<E> implements Decue<E>, Iterable<E> {

    private Node<E> firstElement;
    private Node<E> lastElement;
    private Node<E> removedElement;
    private int size;

    @Override
    public void insertFirst(E value) {
        Node<E> element = new Node<>(value, firstElement, null);
        if (!isEmpty()) {
            firstElement.prev = element;
        } else {
            lastElement = element;
        }
        firstElement = element;
        size++;
    }

    @Override
    public void insertLast(E value) {
        Node<E> element = new Node<>(value, null, lastElement);
        if (!isEmpty()) {
            lastElement.next = element;
        } else {
            firstElement = element;
        }
        lastElement = element;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        removedElement = firstElement;
        if (removedElement.next != null) {
            firstElement = removedElement.next;
        }
        firstElement.prev = null;
        size--;
        return removedElement.item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        removedElement = lastElement;
        if (removedElement.prev != null) {
            lastElement = removedElement.prev;
        }
        lastElement.next = null;
        size--;
        return removedElement.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> element = firstElement;
        while (element != null) {
            if (element.item.equals(value)) {
                element.prev.next = element.next;
                element.next.prev = element.prev;
                size--;
                return true;
            }
            element = element.next;
        }
        return false;
    }

    @Override
    public boolean contains(E value) {
        Node<E> element = firstElement;
        while (element != null) {
            if (element.item.equals(value)) {
                return true;
            }
            element = element.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> element = firstElement;
        while (element != null) {
            sb.append(element.item);
            if (element.next != null) {
                sb.append(" <-> ");
            }
            element = element.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            int i = 1;

            @Override
            public boolean hasNext() {
                return i <= size;
            }

            @Override
            public E next() {
                removedElement = firstElement;
                firstElement = firstElement.next;
                i++;
                return removedElement.item;
            }
        };
        return it;
    }
}