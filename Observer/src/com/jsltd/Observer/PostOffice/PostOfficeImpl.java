package com.jsltd.Observer.PostOffice;

import com.jsltd.Observer.Subscriber.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PostOfficeImpl implements PostOffice{
    HashMap<String, List<Person>> subscriptions = new HashMap<String, List<Person>>();
    public void subscribe(Person person, String newsletter) {
        if (subscriptions.containsKey (newsletter)) {
            List<Person> p = subscriptions.get(newsletter);
            //subscriptions.get(newsletter).add(person);
            try {
                p.add(person);
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
        } else {
            List<Person> persons = new ArrayList<>(Arrays.asList(person));
            subscriptions.put(newsletter, persons);
        }
    }
    public void unsubscribe(Person person, String newsletter) {
        if (subscriptions.containsKey (newsletter)) {
            subscriptions.get(newsletter).remove(person);
        } else {
            System.out.print("Издание не найдено");
        }
    }
    public void update(String newsletter) {
        if (subscriptions.containsKey (newsletter)) {
            for (Person person: subscriptions.get(newsletter)) {
                person.update(newsletter);
            }
        }
    }
}
