package com.jsltd.salad.vegetables.Solanaceous;

public class Tomato extends Solanaceous {
    int koefColories = 3;

    public Tomato() {
        super("Tomato", 3.77, 300);
    }


    @Override
    public double getCalories() {
        return koefColories * calory * value;
    }
}
