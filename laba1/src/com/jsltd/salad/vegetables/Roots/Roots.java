package com.jsltd.salad.vegetables.Roots;

import com.jsltd.salad.vegetables.Vegetables;

public abstract class Roots extends Vegetables {

    public Roots(String name, double calories, double count) {
        super(name, calories, count);
        setCategory("Root vegetables");
    }
}
