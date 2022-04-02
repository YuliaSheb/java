package com.jsltd.Observer.Subscriber;

import com.jsltd.Observer.Post.PostOffice;
import com.jsltd.Observer.PublishingHouse.Publication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class People {

    private String name;

    public People(String name) {
        this.name = name;
    }

    public void handlEvent(String newPublication) {
        System.out.println("Подписчик " +name + " получил издания: " + newPublication);
    }
    HashMap<Publication, List<People>> nameAndPublication = new HashMap<Publication, List<People>>();

    public void subscribe(People person, Publication newsletter, PostOffice postOffice) {
        if (nameAndPublication.containsKey (newsletter)) {
            nameAndPublication.get(newsletter).add(person);
            postOffice.registerPeople(this);
        } else {
            List<People> persons = Arrays.asList(person);
            nameAndPublication.put(newsletter, persons);
        }
    }
    public void unsubscribe(People person, Publication newsletter, PostOffice postOffice) {
        if (nameAndPublication.containsKey (newsletter)) {
            nameAndPublication.get(newsletter).remove(person);
            postOffice.removePeople(this);
        } else {
            System.out.print("Издание не найдено");
        }
    }
}
