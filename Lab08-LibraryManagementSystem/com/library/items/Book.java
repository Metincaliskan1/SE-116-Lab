package com.library.items;

public class Book extends LibraryItem{
    private String author;
    public Book(int itemId,String title,String author){
        super(itemId,title);
        this.author=author;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


    public int getItemId() {
        return super.getItemId();
    }
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public String toString(){
        return super.getItemId()+" "+super.getTitle()+" "+getAuthor();
    }

    public String getItemType(){
        return "Book";
    }
}
