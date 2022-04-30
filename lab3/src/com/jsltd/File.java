package com.jsltd;

public class File extends Component{
    public File(String name) {
        super(name);
    }

    public void create() {
        System.out.println(name);
    }
}
