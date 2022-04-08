/*Разработать систему Почтовое отделение. Из издательства в почтовое отделение поступают издаваемые газеты
 и журналы.
Почтовое отделение отправляет полученные печатные издания соответсвующим подписчикам*/
package com.jsltd.Observer;

import com.jsltd.Observer.PostOffice.PostOfficeImpl;
import com.jsltd.Observer.PublisherHouse.Periodical;
import com.jsltd.Observer.PublisherHouse.PublishingHouseImpl;
import com.jsltd.Observer.Subscriber.Person;

public class Process {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        var publishingHouse = new PublishingHouseImpl();
        // Create two post offices and add subscribers
        var postOfficeOne = new PostOfficeImpl();
        var postOfficeTwo = new PostOfficeImpl();

        Person yulia = new Person(ANSI_WHITE+"Шебеко Юлия");
        postOfficeOne.subscribe(yulia, Periodical.THE_GUARDIAN);
        postOfficeOne.subscribe(yulia, Periodical.POSITIVE_NEWS);
        Person katya = new Person(ANSI_WHITE+"Калинина Екатерина");
        postOfficeOne.subscribe(katya, Periodical.THE_TIMES);
        Person vika = new Person(ANSI_WHITE+"Богданова Виктория");
        postOfficeOne.subscribe(vika, Periodical.THE_GUARDIAN);
        postOfficeOne.subscribe(vika, Periodical.THE_WASHINGTON_POST);
        Person eugene = new Person(ANSI_WHITE+"Абреу-Монтьель Евгений");
        postOfficeTwo.subscribe(eugene, Periodical.THE_WASHINGTON_POST);

        publishingHouse.addPostOffice(postOfficeOne);
        publishingHouse.addPostOffice(postOfficeTwo);

        // Print periodical and notify
        publishingHouse.publish(Periodical.THE_WASHINGTON_POST);
        publishingHouse.publish(Periodical.POSITIVE_NEWS);
        publishingHouse.publish(Periodical.THE_GUARDIAN);
        publishingHouse.publish(Periodical.THE_TIMES);

        // Unsubscribe and check
        postOfficeOne.unsubscribe(katya, Periodical.THE_TIMES);
        postOfficeOne.unsubscribe(vika, Periodical.THE_GUARDIAN);
        publishingHouse.publish(Periodical.THE_TIMES);
        publishingHouse.publish(Periodical.THE_GUARDIAN);

        System.out.println(ANSI_GREEN+" Done!");
    }
}
