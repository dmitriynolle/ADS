package ru.gb;

import ru.gb.deque.DegueImpl;
import ru.gb.queue.QueueImpl;

public class Main {

    public static void main(String[] args) {

//        задание 1
        Integer[] arr = new Integer[30];
        for (int i = 0; i < arr.length; i++) {
            if (i < 11)
                arr[i] = i;
            else arr[i] = i + 1;
        }
        System.out.println(display(arr));
        System.out.println(BinarySearch.search(arr));


//        задание 2
        DegueImpl<Integer> deque = new DegueImpl<>(5);
        System.out.println("add element: " + deque.insertRight(34));
        System.out.println("add element: " + deque.insertRight(12));
        System.out.println("add element: " + deque.insertRight(20));
        System.out.println("add element: " + deque.insertLeft(16));
        System.out.println("add element: " + deque.insertRight(17));
        System.out.println("add element: " + deque.insertRight(13));

        deque.display();
        deque.removeRight();
        deque.display();
        System.out.println("add element: " + deque.insertRight(15));
        System.out.println("add element: " + deque.insertRight(15));
        deque.display();
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        deque.display();
        System.out.println("add element: " + deque.insertLeft(16));
        System.out.println("add element: " + deque.insertLeft(16));
        deque.display();
        deque.removeRight();
        deque.removeRight();
        deque.removeRight();
        deque.display();
        System.out.println("add element: " + deque.insertRight(13));
        deque.display();


//        задание 3
        QueueImpl<Integer> queue = new QueueImpl<>(5);
        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(17));
        System.out.println("add element: " + queue.insert(13));

        queue.display();
        queue.remove();
        queue.display();
        System.out.println("add element: " + queue.insert(15));
        System.out.println("add element: " + queue.insert(11));
        queue.display();
        queue.remove();
        queue.remove();
        queue.display();
        System.out.println("add element: " + queue.insert(11));
        queue.display();

    }

    public static String display(Integer[] arr) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1)
                sb.append(", ");
        }
        return sb.toString();
    }
}