package ui;

public class ItemInfo {
    private String name;
    private String description;

    public ItemInfo(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
}
