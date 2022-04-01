package com.jsltd.Observer;

import com.jsltd.Observer.Post.ProcessPost;
import com.jsltd.Observer.PublishingHouse.ProcessPublishingHouse;
import com.jsltd.Observer.Subscriber.People;

public class PostOffice {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args) {
        var processPost = new ProcessPost();
        var processPublishingHouse = new ProcessPublishingHouse();

        processPublishingHouse.addPublication("The Guardian");
        processPublishingHouse.addPublication("Positive News");
        processPublishingHouse.addPublication("The Times");
        processPublishingHouse.addPublication("The Washington Post");

        new People(ANSI_WHITE+"Шебеко Юлия", processPost);
        new People(ANSI_WHITE+"Калинина Екатерина", processPost);
        new People(ANSI_WHITE+"Богданова Виктория", processPost);
        new People(ANSI_WHITE+"Абреу-Монтьель Евгений", processPost);

        processPost.setPublicationPost(ANSI_GREEN+" Done!");
    }
}
