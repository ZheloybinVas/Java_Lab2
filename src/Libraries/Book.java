package Libraries;

public class Book {
    private String author;
    private String name;
    private double price;
    private int year;

    public String getAuthor(){return author;}
    public String getName(){
        return name;
    }
    public double getPrice(){return price;}
    public int getYear(){
        return year;
    }

    public void setAuthor(String author){
        this.author=author;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price){this.price=price;}
    public void setYear(int year){
        this.year=year;
    }


    public Book(){
        author="не определено";
        name="не определено";
        price=0.0;
        year=0;
    }
    public Book(String author,String name,double price,int year){
        this.author=author;
        this.name=name;
        this.price=price;
        this.year=year;
    }
    public Book(String author,int year){
        this();
        this.author=author;
        this.year=year;
    }
}
