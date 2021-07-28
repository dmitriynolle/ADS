package ru.gb.deque;

public class DegueImpl <E> implements Deque <E>{

    public static final int HEAD_DEFAULT = 0;
    public static final int TAIL_DEFAULT = -1;
    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;

    public DegueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insertLeft(E value) {
        if (head == 0) {
            return false;
        }

        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (head - 1 == tail) {
            return null;
        }

        E value = data[head++];
        size--;

        return value;
    }

    @Override
    public E removeRight() {
        if (isEmpty() || head == tail + 1) {
            return null;
        }

        E value = data[tail--];
        size--;

        return value;
    }

    @Override
    public boolean insert(Object value) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--> [");
        for (int i = head; i <= tail; i++) {
            sb.append(data[i]);
            if (i != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
