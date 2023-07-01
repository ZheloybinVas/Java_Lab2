package Libraries;

public class ChildrenLibrary {
    private ChildrenLibraryHall[]mas;
    private int size=0;

    public int getSize(){return size;}

    public ChildrenLibrary(int size, int[]masb){
        this.size=size;

        mas = new ChildrenLibraryHall[size];
        for(int i=0;i<size;i++){
            mas[i]=new ChildrenLibraryHall("12+",masb[i]);
        }
    }
    public ChildrenLibrary(ChildrenLibraryHall[]mas){
        size=mas.length;
        this.mas=mas;
    }


    public int getCountHall(){//возвращает количество залов
        return size;
    }

    public int getCountBooks(){//возвращает количество книг в библеотеке
        int kolvobooks=0;
        for(int i=0;i<size;i++){
            kolvobooks += mas[i].getCountBooks();
        }
        return kolvobooks;
    }
    public int getCountBooksInHall(int numz){//возвращает количество книг в зале
        return mas[numz].getCountBooks();
    }

    public double getPriceBooks(){//возвращает стоимость всех книг
        double stoim=0;
        for(int i=0;i<size;i++){
            stoim+=mas[i].getPriceBooks();
        }
        return stoim;
    }

    public ChildrenLibraryHall[] getMasHalls(){//возвращает массив залов
        return mas;
    }

    public ChildrenLibraryHall getHall(int num){//возвращает зал по индексу
        return mas[num];
    }

    public ChildrenBook getBook(int numbook){//возвращает книгу по индексу

        int numz=0;
        int numb=0;
        int z =numbook;

        boolean fl=true;

        for (int i = 0; i <size; i++) {

            if (z >= mas[i].getCountBooks()) {
                z -= mas[i].getCountBooks();
                fl=false;
            }

            if ((z < mas[i].getCountBooks())&&fl) {
                numz = i;
                numb=z;
            break;
            }
        fl=true;
        }
        return mas[numz].getBook(numb);
    }

    public ChildrenBook[] getSortMas(){//возвращает отсортированный массив цен
        double masb[]=new double[getCountBooks()];
        ChildrenBook masn[]=new ChildrenBook[getCountBooks()];

        int num=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<mas[i].getCountBooks();j++){
                masb[num]=mas[i].getBook(j).getPrice();
                masn[num]=mas[i].getBook(j);
                num++;
            }
        }

        for(int j=1;j< masb.length;j++){//сортировка массива(пузырьком)
            for(int i=0;i<masb.length-1;i++){
                if(masb[i]<masb[i+1]){

                    double x=masb[i];
                    masb[i]=masb[i+1];
                    masb[i+1]=x;

                    ChildrenBook y=masn[i];
                    masn[i]=masn[i+1];
                    masn[i+1]=y;
                }
            }
        }

        return masn;
    }


    public void printHalls(){//выводит в консоль список названий залов и количество книг
        for(int i=0;i<size;i++){
            System.out.print(mas[i].getName()+"\t");
            System.out.println(mas[i].getCountBooks());
        }
    }

    public void changeHall(int num, ChildrenLibraryHall m){//изменяет зал по номеру
        mas[num]=m;
    }

    public void changeBook(int numbook,ChildrenBook book){//изменяет книгу по номеру

        int numz=0;
        int numb=0;
        int z =numbook;

        boolean fl=true;

        for (int i = 0; i <size; i++) {

            if (z >= mas[i].getCountBooks()) {
                z -= mas[i].getCountBooks();
                fl=false;
            }

            if ((z < mas[i].getCountBooks())&&fl) {
                numz = i;
                numb=z;
                break;
            }
            fl=true;
        }

        mas[numz].changeBook(numb,book);
    }

    public void addBook(int numbook,ChildrenBook book){//добавляет книгу по номеру

        int numz=0;
        int numb=0;
        int z =numbook;

        boolean fl=true;

        for (int i = 0; i <size; i++) {

            if (z >= mas[i].getCountBooks()) {
                z -= mas[i].getCountBooks();
                fl=false;
            }

            if ((z < mas[i].getCountBooks())&&fl) {
                numz = i;
                numb=z;
                break;
            }
            fl=true;
        }
        mas[numz].addBook(numb,book);
    }

    public void delBook(int numbook){//удаляет книгу по номеру

        int numz=0;
        int numb=0;
        int z =numbook;

        boolean fl=true;

        for (int i = 0; i <size; i++) {

            if (z >= mas[i].getCountBooks()) {
                z -= mas[i].getCountBooks();
                fl=false;
            }

            if ((z < mas[i].getCountBooks())&&fl) {
                numz = i;
                numb=z;
                break;
            }
            fl=true;
        }
        mas[numz].delBook(numb);
    }

    public ChildrenBook getBestBook(){//возвращвет книгу с самой высокой стоимостью
        double stoim=0.0;
        int numhall=0,numbook=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<mas[i].getCountBooks();j++){
                if(stoim<=mas[i].getBook(j).getPrice()){
                    stoim=mas[i].getBook(j).getPrice();
                    numhall=i;
                    numbook=j;
                }
            }

        }
        return mas[numhall].getBook(numbook);
    }
}
