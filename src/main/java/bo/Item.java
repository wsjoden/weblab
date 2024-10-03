package bo;

import db.ItemDB;

import java.util.Collection;

public class Item {
    private String name;
    private String description;
    private int id;
    private int stock;

    static public Collection getItems() {
        return ItemDB.getItems();
    }

    protected Item(String name, String description, int id,int stock) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.stock = stock;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getId(){return id;}
    public int getStock(){return stock;}
    public static Item getItemById(int id){return ItemDB.getItemById(id);}
}
