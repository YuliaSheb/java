package com.jsltd.salad;

import com.jsltd.salad.factory.EnumVegetable;
import com.jsltd.salad.factory.VegetableFactory;
import com.jsltd.salad.vegetables.Vegetables;

import java.util.ArrayList;

public class SaladBuilder {
    public static void main(String[] args) {

        VegetableFactory fact = new VegetableFactory();
        ArrayList<Vegetables> vegetables = new ArrayList<>();
        Vegetables first = fact.createVegetable(EnumVegetable.CUCUMBER);
        vegetables.add(first);
        Vegetables second = fact.createVegetable(EnumVegetable.ZUCCHINI);
        vegetables.add(second);
        Vegetables third = fact.createVegetable(EnumVegetable.PEPPER);
        vegetables.add(third);
        Vegetables fourth = fact.createVegetable(EnumVegetable.RADISH);
        vegetables.add(fourth);
        Vegetables fifth = fact.createVegetable(EnumVegetable.TOMATO);
        vegetables.add(fifth);
        Salad salad = new Salad();
        salad.makeSalad(vegetables);
    }
}
