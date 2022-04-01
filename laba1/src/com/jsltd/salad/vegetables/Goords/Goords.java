package com.jsltd.salad.vegetables.Goords;

import com.jsltd.salad.vegetables.Vegetables;

public abstract class Goords extends Vegetables {

    public Goords(String name, double calories, double weight) {
        super(name, calories, weight);
        setCategory("Goords vegetables");
    }
}
