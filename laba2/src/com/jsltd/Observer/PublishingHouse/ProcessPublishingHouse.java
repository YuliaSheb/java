package com.jsltd.Observer.PublishingHouse;

import java.util.ArrayList;

public class ProcessPublishingHouse implements PublishingHouse {
    private ArrayList<String> publications = new ArrayList<>();
    public void addPublication(String publicy){
        this.publications.add(publicy);
        notifyPost();
    };
    public void removePublication(String publicy){
        this.publications.remove(publicy);
        notifyPost();
    };
    @Override
    public void handleEvent(ArrayList<String> publications) {
        System.out.print("На почту пришла поставка с изданиями: \n"+ publications + "\n==================================\n");
    }

    @Override
    public void notifyPost() {
        handleEvent(this.publications);
    }
}
