package com.jsltd.Observer.Subscriber;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void update(String newsletter) {
        System.out.println("Подписчик " +name + " получил издание: " + newsletter);
    }
}
