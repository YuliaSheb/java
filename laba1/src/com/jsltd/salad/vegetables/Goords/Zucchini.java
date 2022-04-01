package com.jsltd.salad.vegetables.Goords;

import com.jsltd.salad.vegetables.Goords.Goords;

public class Zucchini extends Goords {
    int koef = 8;
    public Zucchini() {
        super("Zucchini", 2, 50);
    }

    @Override
    public double getCalories() {
        return koef*calory*value;
    }
}
