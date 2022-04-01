package com.jsltd.salad.vegetables.Roots;

import com.jsltd.salad.vegetables.Roots.Roots;

public class Carrot extends Roots {
    int koef = 10;
    public Carrot() {
        super("Carrot", 22, 1);
    }

    @Override
    public double getCalories() {
        return koef*calory*value;
    }
}
