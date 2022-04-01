package com.jsltd.Observer.Post;

import com.jsltd.Observer.Subscriber.People;

import java.util.ArrayList;

public class ProcessPost implements Post {
    private ArrayList<People> peoples;
        private String newPublication;

        public ProcessPost() {
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
                people.update(newPublication);
        }
    }
