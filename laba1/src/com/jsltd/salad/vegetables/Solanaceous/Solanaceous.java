package com.jsltd.salad.vegetables.Solanaceous;

import com.jsltd.salad.vegetables.Vegetables;

public abstract class Solanaceous extends Vegetables {

    public Solanaceous(String name, double calories, double size) {
        super(name, calories,size);
        setCategory("Solanaceous vegetables");
    }
}
