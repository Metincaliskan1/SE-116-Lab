package com.library.core;

import com.library.items.Book;
import com.library.items.Magazine;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;

public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library("Oxford Library");
        Book book1=new Book(12314,"Harry Potter","J.K. Rowling");
        Book book2=new Book(15636,"Lord of the rings","J.R.R. Tolkien");
        Magazine magazine=new Magazine(156346,"Magazine",34536);
        /*
        Library.Shelf shelf1=library.new Shelf(1,book1,false);
        library.adShelf(shelf1);
        Library.Shelf shelf2=library.new Shelf(2,book2,true);
        library.adShelf(shelf2);
        Library.Shelf shelf3=library.new Shelf(3,magazine,true);
        library.adShelf(shelf3);
        Library.LoanRecord record = library.lend(1,"Metin");

         */
        library.adShelf(1,book1,false);
        library.adShelf(2,book2,true);
        library.adShelf(3,magazine,true);


        /*
        Library.LoanRecord record = library.lend(1,"Metin");
        library.calculateLateFee(record);
        library.printLibraryStatus();

        record.setBorrowedDayCount(5);
        library.returnItem(record);
        library.printLibraryStatus();
        */
        ArrayList<Library.LoanRecord>lends=new ArrayList<>();

        lends =library.lendAll("Boss");
        library.printLibraryStatus();

        library.returnAll(lends);

        library.printLibraryStatus();

        library.printLoanHistory();

        System.out.println("Total revenue: "+library.getTotalRevenue());





    }
}
