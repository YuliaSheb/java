package com.jsltd.Observer.PublishingHouse;

public enum Publication {
    THE_GUARDIAN ("THE GUARDIAN"),
    POSITIVE_NEWS ("POSITIVE NEWS"),
    THE_TIMES ("THE TIMES"),
    THE_WASHINGTON_POST ("THE WASHINGTON POST");

    private String title;

    Publication(String title) {
        this.title = title;
    }
}
