/*Разработать систему Почтовое отделение. Из издательства в почтовое отделение поступают издаваемые газеты
 и журналы.
Почтовое отделение отправляет полученные печатные издания соответсвующим подписчикам*/
package com.jsltd.Observer;

import com.jsltd.Observer.Post.PostOfficeImpl;
import com.jsltd.Observer.PublishingHouse.Publication;
import com.jsltd.Observer.PublishingHouse.PublishingHouseImpl;
import com.jsltd.Observer.Subscriber.People;

public class Processd {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        var processPost = new PostOfficeImpl();
        var processPublishingHouse = new PublishingHouseImpl();
        processPublishingHouse.notifyPost();

        People yulia = new People(ANSI_WHITE+"Шебеко Юлия");
        People katya = new People(ANSI_WHITE+"Калинина Екатерина");
        People vika = new People(ANSI_WHITE+"Богданова Виктория");
        People eugene = new People(ANSI_WHITE+"Абреу-Монтьель Евгений");

        yulia.subscribe(yulia,Publication.valueOf("THE_TIME"), processPost);
        processPost.setPublicationPost(ANSI_GREEN+" Done!");
    }
}
