package com.library.core;

import com.library.interfaces.LendingService;
import com.library.items.LibraryItem;

import java.util.ArrayList;
import java.util.HashMap;

public class Library implements LendingService {
    private String libraryName;
    private HashMap<Integer,Shelf>shelves;
    private ArrayList<LoanRecord> loanHistory;
    public Library(String libraryName){
        this.libraryName=libraryName;
        shelves= new HashMap<>(0);
        loanHistory=new ArrayList<>(0);
    }

    @Override
    public LoanRecord lend(int shelfNumber, String borrowerName) {
        if (shelves.containsKey(shelfNumber)) {
             if (shelves.get(shelfNumber).getStoredItem() == null) {
                System.out.println("Shelf " + shelfNumber + " is empty.");
                return null;
            }
             else if (shelves.get(shelfNumber).getIsReferenceOnly()) {
                System.out.println("Item " + shelves.get(shelfNumber).getStoredItem().getTitle() + " is reference only.");
                return null;
            }else {
                LoanRecord record = new LoanRecord(borrowerName, shelves.get(shelfNumber), shelves.get(shelfNumber).getStoredItem());
                record.borrowedDayCount = 0;

                System.out.println("Item " + shelves.get(shelfNumber).getStoredItem().getTitle() + " has been borrowed by " + borrowerName);
                shelves.get(shelfNumber).setStoredItem(null);
                loanHistory.add(record);
                return record;
            }
        } else {
            System.out.println("Item couldnt found.");
            return null;
        }

    }
    public void returnItem(LoanRecord lr){
        lr.getShelf().setStoredItem(lr.getBorrowedItem());
        calculateLateFee(lr);
        System.out.println("Item "+lr.getShelf().getStoredItem().getTitle()+" has been returned to the library.");
        System.out.println("The fee of "+lr.borrowFee+" has been paid.");
    }
    public void adShelf(int shelfNumber,LibraryItem storedItem,boolean isReferenceOnly){
        Shelf shelf=new Shelf(shelfNumber,storedItem,isReferenceOnly);
        shelves.put(shelf.shelfNumber,shelf);
    }
    public void calculateLateFee(LoanRecord lr){
        int result= lr.borrowedDayCount*2;
        lr.borrowFee=result;
    }
    public void printLibraryStatus(){
        for (Shelf s: shelves.values()){
            System.out.println(s.shelfNumber);
            System.out.println(s.storedItem);
            System.out.println(s.isReferenceOnly);
            System.out.println("--------------");
        }
    }
    public ArrayList<LoanRecord> lendAll(String borrowerName){
        ArrayList<LoanRecord>newList=new ArrayList<>(0);
        for (Shelf s:shelves.values()){
           LoanRecord result=lend(s.shelfNumber,borrowerName);
           if (result!=null){
               newList.add(result);
           }
        }
        return newList;
    }
    public void returnAll(ArrayList<LoanRecord>records){
        for (LoanRecord lr:records){
            lr.setBorrowedDayCount(5);
            returnItem(lr);
        }
    }
    public void printLoanHistory(){
        for (LoanRecord lr:loanHistory){
            System.out.println("Borrower Name: "+lr.getBorrowerName());
            System.out.println("Borrowed Item: "+lr.getBorrowedItem());
            System.out.println("Fee "+lr.getBorrowFee());
        }
    }
    public  double getTotalRevenue(){
        double sum=0;
        for(LoanRecord lr:loanHistory){
            sum+=lr.getBorrowFee();
        }
        return sum;
    }
    private class Shelf{
        private int shelfNumber;
        private LibraryItem storedItem;
        private boolean isReferenceOnly;
        public Shelf(int shelfNumber,LibraryItem storedItem,boolean isReferenceOnly){
            this.shelfNumber=shelfNumber;
            this.isReferenceOnly=isReferenceOnly;
            this.storedItem=storedItem;

        }
        public int getShelfNumber() {
            return shelfNumber;
        }
        public LibraryItem getStoredItem() {
            return storedItem;
        }
        public boolean getIsReferenceOnly(){
            return isReferenceOnly;
        }
        public void setReferenceOnly(boolean referenceOnly) {
            isReferenceOnly = referenceOnly;
        }
        public void setShelfNumber(int shelfNumber) {
            this.shelfNumber = shelfNumber;
        }
        public void setStoredItem(LibraryItem storedItem) {
            this.storedItem = storedItem;
        }
        @Override
        public String toString(){
            return getShelfNumber()+" "+getIsReferenceOnly()+" "+getStoredItem();
        }
    }
    public static class LoanRecord{
        private String borrowerName;
        private Shelf shelf;
        private LibraryItem borrowedItem;
        private int borrowedDayCount;
        private double borrowFee;

        public LoanRecord(String borrowerName,Shelf shelf,LibraryItem borrowedItem){
            this.borrowerName=borrowerName;
            this.shelf=shelf;
            this.borrowedItem=borrowedItem;
        }

        public String getBorrowerName() {
            return borrowerName;
        }
        public void setBorrowerName(String borrowerName) {
            this.borrowerName = borrowerName;
        }
        public Shelf getShelf() {
            return shelf;
        }
        public void setShelf(Shelf shelf) {
            this.shelf = shelf;
        }
        public LibraryItem getBorrowedItem() {
            return borrowedItem;
        }
        public void setBorrowedItem(LibraryItem borrowedItem) {
            this.borrowedItem = borrowedItem;
        }
        public void setBorrowedDayCount(int dayCount){
            this.borrowedDayCount=dayCount;
        }
        public int getBorrowedDayCount(){return this.borrowedDayCount;}
        public double getBorrowFee(){return this.borrowFee;}
        public void setBorrowFee(double borrowFee){
            this.borrowFee=borrowFee;
        }
    }
}
