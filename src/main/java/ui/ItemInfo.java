package ui;

public class ItemInfo {
    private String name;
    private String description;
    private int id;
    private int stock;

    public ItemInfo(String name, String description,int id,int stock) {
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
}
