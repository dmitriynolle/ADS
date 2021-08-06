package ru.gb;

import java.util.List;

public class Box {
    private String name;
    private int weight;
    private int price;
    private List<Box> box;

    public Box(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Box(String name, int weight, int price, List<Box> box) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.box = box;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " [weight = " + weight + ", price = " + price + "]");
        if (box != null) {
            sb.append("\n " + box);
        }
        return sb.toString();
    }
}
