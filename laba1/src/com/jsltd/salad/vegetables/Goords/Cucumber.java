package com.jsltd.salad.vegetables.Goords;

import com.jsltd.salad.vegetables.Goords.Goords;

public class Cucumber extends Goords {
    int koef = 5;
    public Cucumber() {
        super("Cucumber", 0.7, 100);
    }

    @Override
    public double getCalories() {
        return koef*calory*value;
    }
}
