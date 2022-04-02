package com.jsltd.Observer.Post;

import com.jsltd.Observer.Subscriber.People;

import java.util.ArrayList;

public class PostOfficeImpl implements PostOffice {
    private ArrayList<People> peoples;
    private String newPublication;

    public PostOfficeImpl() {
        peoples = new ArrayList<>();
    }

    public void setPublicationPost(String publicys) {
        this.newPublication = publicys;
        notifyPeople();
    }

    @Override
    public void registerPeople(People people) {
        peoples.add(people);
    }

    @Override
    public void removePeople(People people) {
        peoples.remove(people);
    }

    @Override
    public void notifyPeople() {
        for (People people : peoples)
            people.handlEvent(newPublication);
    }
}
