package com.library.items;

public class Magazine extends LibraryItem{
    private int issueNumber;
    public Magazine(int itemId,String title,int issueNumber){
        super(itemId, title);
        this.issueNumber=issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }


    public int getItemId() {
        return super.getItemId();
    }
    public String getTitle() {
        return super.getTitle();
    }
    @Override
    public String toString(){
        return super.getItemId()+" "+super.getTitle()+" "+getIssueNumber();
    }

    public String getItemType(){
        return "Magazine";
    }


}
