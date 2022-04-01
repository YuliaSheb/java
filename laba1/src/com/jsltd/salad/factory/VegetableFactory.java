package com.jsltd.salad.factory;

import com.jsltd.salad.vegetables.*;
import com.jsltd.salad.vegetables.Goords.Cucumber;
import com.jsltd.salad.vegetables.Goords.Pumpkin;
import com.jsltd.salad.vegetables.Goords.Zucchini;
import com.jsltd.salad.vegetables.Roots.Carrot;
import com.jsltd.salad.vegetables.Roots.Celery;
import com.jsltd.salad.vegetables.Roots.Radish;
import com.jsltd.salad.vegetables.Solanaceous.Eggplant;
import com.jsltd.salad.vegetables.Solanaceous.Pepper;
import com.jsltd.salad.vegetables.Solanaceous.Tomato;

public class VegetableFactory {

    public Vegetables createVegetable(EnumVegetable type) {
        Vegetables vegetables = null;

        switch (type) {
            case CUCUMBER:
                vegetables = new Cucumber();
                break;
            case PUMPKIN:
                vegetables = new Pumpkin();
                break;
            case ZUCCHINI:
                vegetables = new Zucchini();
                break;
            case CARROT:
                vegetables = new Carrot();
                break;
            case CELERY:
                vegetables = new Celery();
                break;
            case RADISH:
                vegetables = new Radish();
                break;
            case PEPPER:
                vegetables = new Pepper();
                break;
            case TOMATO:
                vegetables = new Tomato();
                break;
            case EGGPLANT:
                vegetables = new Eggplant();
                break;
            default:
                throw new IllegalArgumentException("Wrong vegetable type:" + type);
        }
        return vegetables;
    }
}
