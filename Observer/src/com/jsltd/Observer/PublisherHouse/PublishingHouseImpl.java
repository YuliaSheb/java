package com.jsltd.Observer.PublisherHouse;

import com.jsltd.Observer.PostOffice.PostOffice;

import java.util.ArrayList;
import java.util.List;

public class PublishingHouseImpl implements PublishingHouse {
    List<PostOffice> postOffices = new ArrayList<PostOffice>();
    public void addPostOffice(PostOffice postOffice) {
        postOffices.add(postOffice);
    }
    public void removePostOffice(PostOffice postOffice) {
        postOffices.remove(postOffice);
    }
    public void publish(String newsletter) {
        for (PostOffice postOffice: postOffices) {
            postOffice.update(newsletter);
        }
    }
}
