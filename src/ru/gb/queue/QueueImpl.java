package ru.gb.queue;

public class QueueImpl<E> implements Queue<E> {

    public static final int HEAD_DEFAULT = 0;
    public static final int TAIL_DEFAULT = -1;
    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;
    protected int center;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
        this.center = 0;
    }

    @Override
    public boolean insert(E value) {

        if (head == tail && isFull()) {
            return false;
        }
        if (head > 0 && center < head && isFull()) {
            data[center++] = value;
            size++;
            return true;
        } else if (!isFull()) {
            data[++tail] = value;
            size++;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E value = data[head];
        data[head] = null;
        if (head == tail) {
            head = 0;
            tail = center - 1;
        } else
            head++;
        size--;

        return value;
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
        return size + (head - center) == data.length;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--> [");
        for (int i = 0; i <= tail; i++) {
            sb.append(data[i]);
            if (i != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
