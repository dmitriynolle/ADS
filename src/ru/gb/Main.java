package ru.gb;

public class Main {

    public static void main(String[] args) {
        DecueImpl<Integer> decue = new DecueImpl<>();
        decue.insertFirst(1);
        decue.insertLast(2);
        decue.insertFirst(3);
        decue.insertLast(4);
        decue.insertFirst(5);
        decue.insertFirst(6);
        decue.insertLast(7);
        decue.insertFirst(8);
        decue.insertLast(9);
        decue.insertFirst(0);
        decue.display();

        System.out.println(decue.remove(2));
        System.out.println(decue.contains(6));
        decue.display();
        decue.removeLast();
        decue.removeFirst();
        decue.removeLast();
        decue.removeFirst();
        decue.removeLast();
        decue.removeLast();

        decue.display();

        for (Integer value : decue) {
            System.out.println(value);
        }
    }
}