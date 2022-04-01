package com.jsltd.salad.vegetables.Solanaceous;

import com.jsltd.salad.vegetables.Solanaceous.Solanaceous;

public class Pepper extends Solanaceous {
    int koef = 2;
    public Pepper() {
        super("Pepper", 2.01, 75);
    }

    @Override
    public double getCalories() {
        return koef*calory*value;
    }
}
