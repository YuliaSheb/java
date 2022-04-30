package com.jsltd;

public class Main {

    public static void main(String[] args) {
        Component system = new Directory("System:");
        Component diskE = new Directory("Disk E");
        Component diskD = new Directory("Disk D");
        Component diskC = new Directory("Disk C");
        Component folder1 = new File("Folder 1");
        Component doc = new File("Text.txt");
        Component doc2 = new File("Texxt.txt");
        Component folder2 = new File("Folder 2");
        diskC.Add(folder2);
        diskD.Add(folder1);
        diskC.Add(doc);
        diskC.Add(doc2);
        diskC.Remove(doc2);
        system.Add(diskE);
        system.Add(diskC);
        system.Add(diskD);
        system.create();
    }
}
