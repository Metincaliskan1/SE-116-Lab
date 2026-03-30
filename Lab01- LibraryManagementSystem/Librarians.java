

public class Librarians {
    private int EmployeeID;
    private String name;
    private int age;
    private Books[] listOfBooks;


    public Librarians(int EmployeeID,String name,int age){
        this.age=age;
        this.name=name;
        this.EmployeeID=EmployeeID;
        this.listOfBooks=new Books[5];
    }

    public void addBook(Books book){

        for (int i=0;i<5;i++){
            if (listOfBooks[i]==null){
                listOfBooks[i]=book;
            }
            if (listOfBooks[i]==null){
                continue;
            }
        }



    }

    public void removebook(String Isbn){
        for (int i=0;i<5;i++){
            if(listOfBooks[i].equals(Isbn)){
                listOfBooks[i]=null;
                System.out.println("Book removed");
            }
            else {
                System.out.println("Book couldnt find");
            }
        }
    }

    public void updatePrice(Books book, double newPrice){
        for (int i=0;i<5;i++){
            if(listOfBooks[i].equals(book)){
                listOfBooks[i].setPrice(newPrice);
                System.out.println("Price has been changed.");
            }
            else {
                System.out.println("Book couldnt find");
            }
        }
    }
    public void findBookAndApplyDiscount(String isbn, double discountPercentage){
        for (int i=0;i<5;i++){
            if(listOfBooks[i].equals(isbn)){

                double new_price=listOfBooks[i].getPrice()-(listOfBooks[i].getPrice()*discountPercentage)/100;
                System.out.println("Price has been changed.");
                System.out.println("New price: "+new_price);

            }
            else {
                System.out.println("Book couldnt find");
            }
        }
    }

    public void displayAllBooks(){
        for (int i=0;i<5;i++){
            if (listOfBooks[i]!=null)
                listOfBooks[i].displayBook();
            if (listOfBooks[i]==null){
                continue;
            }
        }
    }





}
