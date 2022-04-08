package com.jsltd.Observer.PublisherHouse;

import com.jsltd.Observer.PostOffice.PostOffice;

public interface PublishingHouse {
    void addPostOffice(PostOffice postOffice);
    void removePostOffice(PostOffice postOffice);
    void publish(String newsletter);
}
