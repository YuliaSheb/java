package com.jsltd.salad.vegetables.Goords;

import com.jsltd.salad.vegetables.Goords.Goords;

public class Pumpkin extends Goords {
    int koef = 11;
    public Pumpkin() {
        super("Pumpkin", 0.22, 200);
    }

    @Override
    public double getCalories() {
        return koef*calory*value;
    }
}
