package com.jsltd.salad.vegetables.Solanaceous;

import com.jsltd.salad.vegetables.Solanaceous.Solanaceous;

public class Eggplant extends Solanaceous {
    int koef = 5;
    public Eggplant() {
        super("Eggplant", 1.33, 150);
    }

    @Override
    public double getCalories() {
        return koef*calory*value;
    }
}
