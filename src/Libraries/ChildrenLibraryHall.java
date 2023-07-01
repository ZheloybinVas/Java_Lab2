package Libraries;

public class ChildrenLibraryHall {
    private ChildrenBook []mas;
    private String name;
    private int size=0;

    public String getName(){return name;}
    public int getSize(){return size;}

    public ChildrenLibraryHall(){
        name="12+";
        size=10;
        mas =new ChildrenBook[size];
        for(int i=0;i<size;i++){//заполнение массива книгами, с параметрами по умолчанию
            mas[i]=new ChildrenBook();
        }
    }
    public  ChildrenLibraryHall(String name, int countbooks){
        this.name = name;
        this.size = countbooks;

        mas = new ChildrenBook[size];
        for(int i=0;i<size;i++){
        mas[i] = new ChildrenBook();
        }
    }
    public ChildrenLibraryHall(String name,ChildrenBook[] mas){
        this.name=name;
        this.mas=mas;
        this.size = mas.length;
    }

    public String getNameBook(int numbook){//возврвщает название книги
        return mas[numbook].getName();
    }


    public int getCountBooks(){//возвращает количество книг взале
        return size;
    }

    public void printNamesBooks(){//выводит в консоль названия вех книг
        System.out.println("Список книг:");
        for(int i=0;i<size;i++){
            System.out.println(mas[i].getName());
        }
    }

    public double getPriceBooks() {//возвращает общую стоимость всех книг в зале
        double st = 0;
        for (int i = 0; i < size; i++) {
            st = mas[i].getPrice();
        }
        return st;
    }

    public ChildrenBook getBook(int numbook){//возвращает книгу по индексу
        if(numbook<0||numbook>=size){
            return null;
        }
        else{
            return mas[numbook];
        }
    }

    public void changeBook(int numbook,ChildrenBook book){//заменяет книгу по индексу
        mas[numbook] = book;
    }

    public void addBook(int numbook,ChildrenBook book){//добаляет книгу по индексу
        size++;
        ChildrenBook[] mas2 = new ChildrenBook[size];
        for(int i=0;i<size;i++){
            if(i==numbook){
                mas2[i]=book;
            }
            if(i<numbook){
                mas2[i]=mas[i];
            }
            if(i>numbook){
                mas2[i]=mas[i-1];
            }
        }
        mas=mas2;
    }
    public void delBook(int numbook){//удаляет книгу по индексу
        size--;
        ChildrenBook[] mas2=new ChildrenBook[size];
        for(int i=0;i<size;i++){
            if(i<numbook){
                mas2[i]=mas[i];
            }
            if(i>=numbook){
                mas2[i]=mas[i+1];
            }
        }
        mas=mas2;
    }

    public ChildrenBook getCheapBook(){//возвращает книгу с самой высокой стоимостью
        int cbook=0;
        double stoim=0.0;
        for(int i=0;i<size;i++){
            if(stoim<=mas[i].getPrice()){
                cbook=i;
            }
        }
        return mas[cbook];
    }

    public void changeHall(ChildrenBook[]masb){//изменяет зал
        mas=masb;
    }

    public double getPriceBook(int num){//возврвщает название книги
        return mas[num].getPrice();
    }
}
