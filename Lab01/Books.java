public class Books {
    private String isbn;
    private String title;
    private int pageCount;
    private double price;

    public Books(String isbn,String title,int pageCount,double price){
        this.isbn=isbn;
        this.pageCount=pageCount;
        this.price=price;
        this.title=title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setPageCount(int PageCount){
        this.pageCount=PageCount;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
    public void displayBook(){
        System.out.println("The book title: "+getTitle());
        System.out.println("The book isbn: "+getIsbn());
        System.out.println("The book pageCount: "+getPageCount());
        System.out.println("The book price: "+getPrice());
    }


}
