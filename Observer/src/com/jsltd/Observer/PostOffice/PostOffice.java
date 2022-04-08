package com.jsltd.Observer.PostOffice;

import com.jsltd.Observer.Subscriber.Person;

public interface PostOffice {
    void subscribe(Person person, String newsletter);
    void unsubscribe(Person person, String newsletter);
    void update(String newsletter);
}
