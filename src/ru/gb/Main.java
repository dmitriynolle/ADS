package ru.gb;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Box> boxList = new ArrayList<>();
    private static List<Box> resultBox = new ArrayList<>();
    private static final int bigBoxSize = 10;

    public static void main(String[] args) {
//        Задание 1
        System.out.println(exponentiation(2, 3));

//        Задание 2
        boxList.add(new Box("Box1", 12, 4));
        boxList.add(new Box("Box2", 2, 2));
        boxList.add(new Box("Box3", 1, 1));
        boxList.add(new Box("Box4", 1, 2));
        boxList.add(new Box("Box5", 4, 10));

        for (Box box : boxList) {
            System.out.println(box.toString());
        }
        System.out.println("\n" + findAll());

    }

    protected static Box findAll() {
        for (int i = 0; i < boxList.size(); i++) {

            if (i == 0) {
                find(boxList.size());
            } else {
                find(boxList.size() - 1);
            }
            rotate(boxList.size());
        }
        int price = 0;
        int winner = 0;
        for (int i = 0; i < resultBox.size(); i++) {
            if (resultBox.get(i).getPrice() > price) {
                price = resultBox.get(i).getPrice();
                winner = i;
            }
        }
        return resultBox.get(winner);
    }

    private static void find(int length) {
        if (length == 0) {
            return;
        }
        int weight = 0;
        int price = 0;
        List<Box> temp = new ArrayList<>();
        find(length - 1);
        for (int j = 0; j < length; j++) {
            weight += boxList.get(j).getWeight();
            price += boxList.get(j).getPrice();
            temp.add(boxList.get(j));
        }
        if (weight <= bigBoxSize) {
            resultBox.add(new Box("BigBox", weight, price, temp));
        }
    }

    private static void rotate(int length) {
        int first = boxList.size() - length;

        Box temp = boxList.get(first);
        for (int i = first + 1; i < boxList.size(); i++) {
            boxList.set(i - 1, boxList.get(i));
        }
        boxList.set(boxList.size() - 1, temp);
    }

    private static int exponentiation(int base, int extent) {
        if (extent == 1) return base;
        return base * exponentiation(base, extent - 1);
    }
}