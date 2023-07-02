package Libraries;

public class ScientificBook extends Book {
    private double indcet;

    public void setIndcet(double ind){indcet=ind;}

    public double getIndcet(){return indcet;}

    ScientificBook(){
        super();
        indcet=0.0;
    }
    ScientificBook(String author, int year){
        super(author,year);
        indcet=0.0;
    }
    ScientificBook(String author,String name,double price,int year){
        super(author,name,price,year);
        indcet=0.0;
    }
}
