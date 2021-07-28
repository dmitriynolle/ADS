package ru.gb;

public class BinarySearch {

    public static int search(Integer[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int base;
        if (arr.length == 0) return 1;
        while (end >= start) {
            base = (start + end) / 2;

            if (base == arr[base]) {
                start = base + 1;
            } else if (base < arr[base]) {
                if (base - 1 == arr[base - 1]) {
                    return base;
                } else {
                    end = base - 1;
                }
            }
        }
        return -1;
    }
}
