package ru.gb;

public class Notebook {
    private String brand;
    private float price;
    private double ram;

    public Notebook(String brand, float price, double ram) {
        this.brand = brand;
        this.price = price;
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public float getPrice() {
        return price;
    }

    public double getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                '}';
    }
}