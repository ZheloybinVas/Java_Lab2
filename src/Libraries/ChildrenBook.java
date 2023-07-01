package Libraries;

public class ChildrenBook extends Book{
    private int age;

    public void setAge(int voz){this.age=age;}

    public int getAge(){return age;}

    public ChildrenBook(){
        super();
        age=0;
    }
    public ChildrenBook(String author, int year){
        super(author,year);
        age=0;
    }
    public ChildrenBook(String author,String name,double price,int year,int age){
        super(author,name,price,year);
        this.age=age;
    }
}
