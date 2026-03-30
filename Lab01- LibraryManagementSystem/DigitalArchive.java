public class DigitalArchive {
    public static void main(String[] args){
        Librarians librarian = new Librarians(12345,"Kutay",19);
        Books book1 = new Books("123TR45","yüzüklerin efendisi",185,90);
        Books book2 = new Books("123TR45688","Harry potter",190,100);

        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.displayAllBooks();


    }
}
