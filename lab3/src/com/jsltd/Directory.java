package com.jsltd;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Component {
    private List<Component> components = new ArrayList<>();

    public void Add(Component obj) {
        components.add(obj);
    }

    public void Remove(Component obj) {
        components.remove(obj);
    }

    public Directory(String name){super(name);}

    @Override
    public void create() {
        System.out.println("\nУзел: "+name);
        if (components.isEmpty()){
            System.out.println("Список не создан!");
        }
        else {
            System.out.println("Подузел: ");
        }

        for(Component c : components) {
            System.out.print(c.name +", " );
        }

        for(Component c : components) {
            System.out.print("\n\n*****\n"  );
            c.create();
        }
    }
}
