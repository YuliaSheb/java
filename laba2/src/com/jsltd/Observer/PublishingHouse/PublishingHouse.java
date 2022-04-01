package com.jsltd.Observer.PublishingHouse;

import java.util.ArrayList;

public interface PublishingHouse {
    public void handleEvent(
            ArrayList<String> publications
    );
    void notifyPost();
}
