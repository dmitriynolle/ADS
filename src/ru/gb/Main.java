package ru.gb;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Notebook[] notebooks = new Notebook[5000];
        for (int i = 0; i < 5000; i += 5) {
            notebooks[i] = new Notebook("Lenuvo", 500 + (int) (Math.random() * 1000), Math.pow(2, (1 + (int) (Math.random() * 7))));
            notebooks[i + 1] = new Notebook("Asos", 500 + (int) (Math.random() * 1000), Math.pow(2, (1 + (int) (Math.random() * 7))));
            notebooks[i + 2] = new Notebook("MacNote", 500 + (int) (Math.random() * 1000), Math.pow(2, (1 + (int) (Math.random() * 7))));
            notebooks[i + 3] = new Notebook("Eser", 500 + (int) (Math.random() * 1000), Math.pow(2, (1 + (int) (Math.random() * 7))));
            notebooks[i + 4] = new Notebook("Xamiou", 500 + (int) (Math.random() * 1000), Math.pow(2, (1 + (int) (Math.random() * 7))));

        }
        System.out.println("Не отсортирован");
        out(notebooks);

        notebooks = quickSort(Arrays.asList(notebooks), 1).toArray(notebooks);
        System.out.println("Сортирован");
        out(notebooks);
    }

    public static List<Notebook> quickSort(List<Notebook> arr, int attribute) {

        if (arr.isEmpty()) {
            return arr;
        }

        Notebook base = arr.get(0);

        List<Notebook> left = new LinkedList<>();
        List<Notebook> middle = new LinkedList<>();
        List<Notebook> right = new LinkedList<>();


        for (Notebook n : arr) {
            if (attribute == 1) {
                if ((int) (n.getPrice() / 100) == (int) (base.getPrice() / 100)) {
                    middle.add(n);
                } else if ((int) (n.getPrice() / 100) > (int) (base.getPrice() / 100)) {
                    right.add(n);

                } else {
                    left.add(n);
                }
            }

            if (attribute == 2) {
                if (n.getRam() == base.getRam()) {
                    middle.add(n);
                } else if (n.getRam() > base.getRam()) {
                    right.add(n);

                } else {
                    left.add(n);
                }
            }

            if (attribute == 3) {
                if (n.getBrand().compareTo(base.getBrand()) == 0) {
                    middle.add(n);
                } else if (n.getBrand().compareTo(base.getBrand()) > 0) {
                    right.add(n);

                } else {
                    left.add(n);
                }
            }
        }
        if (middle.size() > 1 && attribute == 1)
            middle = quickSort(middle, 2);
        if (middle.size() > 1 && attribute == 2)
            middle = quickSort(middle, 3);

        left = quickSort(left, 1);
        right = quickSort(right, 1);

        left.addAll(middle);
        left.addAll(right);

        return left;
    }

    public static void out(Notebook[] notebooks) {
        for (Notebook n : notebooks) {
            System.out.println(n.toString());
        }
    }
}