package com.library.items;

public abstract class LibraryItem {
    private int itemId;
    private String title;

    public LibraryItem(int itemId,String title){
        this.itemId=itemId;
        this.title=title;
    }
    public String getTitle() {
        return title;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        return title+" "+itemId;
    }
    public abstract String getItemType();



}
