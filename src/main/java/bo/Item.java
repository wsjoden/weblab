package bo;

import db.ItemDB;

import java.util.Collection;

public class Item {
    private String name;
    private String description;
    private int id;

    static public Collection getItems() {
        return ItemDB.getItems();
    }

    protected Item(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getId(){return id;}
}
