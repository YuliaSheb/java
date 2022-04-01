package com.jsltd.salad;

import com.jsltd.salad.vegetables.Vegetables;

import java.util.ArrayList;

public class Salad {
    private ArrayList<Vegetables> list = new ArrayList<>();

    public void makeSalad(ArrayList<Vegetables> list) {
        this.list = list;
        if (list.isEmpty()) {
            System.out.println("You haven't added any ingredients yet!");
            return;
        }

        System.out.println("The salad contains:");
        for (Vegetables vegetable : list) {
            System.out.println(vegetable.toString());
            System.out.print("Calorie: ");
            System.out.println(vegetable.getCalories());
        }
        System.out.println("*************************");
        System.out.println("Total energy: " + countCalories() + "kcal");
    }

    public double countCalories() {
        double calories = 0.0;

        for (Vegetables vegetable : list) {
            calories += vegetable.getCalories();
        }
        return calories;
    }
}
