package org.example.coffe.order;


public class Order {
    private String name;
    public static int current = 1;
    private int order;


    public Order(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }
}