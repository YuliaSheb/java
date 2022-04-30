package com.jsltd;

public abstract class Component {
    protected String name;
    public Component(String name) {
        this.name= name;
    }
    public void Add(Component obj) {}
    public void Remove(Component obj) {}
    public abstract void create();
}
