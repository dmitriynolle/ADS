package ru.gb;

public class Main {

    public static void main(String[] args) {
        int counter = 0;
        boolean isBalansed;
        for (int i = 0; i < 20; i++) {
            TreeImpl<Integer>tree = new TreeImpl<>(6);
            while (tree.add((int) ((Math.random()*200)-100))){}
            tree.display();
            isBalansed = tree.isBalanced(tree.getRoot());
            System.out.println(isBalansed);
            if (!isBalansed){
                counter++;
            };
        }
        System.out.println((float) counter/20*100 + "%");
    }
}