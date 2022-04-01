package com.jsltd.salad.vegetables.Roots;

import com.jsltd.salad.vegetables.Roots.Roots;

public class Radish extends Roots {
    int koef = 4;
    public Radish() {
        super("Radish", 5.2, 10);
    }

    @Override
    public double getCalories() {
        return koef*calory*value;
    }
}
