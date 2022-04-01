package com.jsltd.salad.vegetables.Roots;

import com.jsltd.salad.vegetables.Roots.Roots;

public class Celery extends Roots {
    int koef = 7;
    public Celery() {
        super("Celery", 50, 1);
    }

    @Override
    public double getCalories() {
        return koef*calory*value;
    }
}
