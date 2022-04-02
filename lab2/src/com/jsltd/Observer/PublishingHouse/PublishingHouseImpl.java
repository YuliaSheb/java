package com.jsltd.Observer.PublishingHouse;

import java.util.ArrayList;
import java.util.Arrays;

public class PublishingHouseImpl implements PublishingHouse {

    public String getlist(){
        return Arrays.toString(Publication.values());
    }

    @Override
    public void handleEvent() {
        System.out.print("На почту пришла поставка с изданиями: \n"+ Arrays.toString(Publication.values()) + "\n==================================\n");
    }

    @Override
    public void notifyPost() {
        handleEvent();
    }
}
