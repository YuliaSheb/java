package com.jsltd.Observer.Post;

import com.jsltd.Observer.Subscriber.People;

public interface Post {
        void registerPeople(People peoples);
        void removePeople(People peoples);
        void notifyPeople();
}
