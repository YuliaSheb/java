package com.jsltd.Observer.Subscriber;

import com.jsltd.Observer.Post.Post;

public class People {

        private String name;

        public People(String name, Post post) {
            this.name = name;
            post.registerPeople(this);
        }

        public void update(String newPublication) {
            System.out.println(name + " получил издания: " + newPublication);
        }
}
