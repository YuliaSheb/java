package com.jsltd.salad.vegetables;

public abstract class Vegetables{
    private String name;
    private String category;
    protected double calory;
    protected double value;

    public Vegetables(String name) {
        this.name = name;
    }

    public Vegetables(String name,double calories,double value) {
        if (calories < 0) {
            throw new IllegalArgumentException("Cannot create vegetable with "
                    + calories + "kcal");
        }
        this.name = name;
        this.calory = calories;
        this.value = value;
    }
    public String getName() {
        return name;
    }

    public abstract double getCalories();

    public String getCategory() {
        return category;
    }
    protected void setName(String name) {
        this.name = name;
    }
    protected void setCategory(String category) {
        this.category = category;
    }
    public String toString(){
        return name;
    }
}
