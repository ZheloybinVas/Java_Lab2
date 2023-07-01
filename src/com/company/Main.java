package com.company;

import Libraries.*;

public class Main {
    public static void main(String[] args) {

        ChildrenLibraryHall[] mas=new ChildrenLibraryHall[5];
        for(int i=0;i<mas.length;i++){//создаём массив залов на 5 элементов

            if(i%2==0){
                mas[i]=new ChildrenLibraryHall();
            }else{
                mas[i]=new ChildrenLibraryHall("+12",5);
            }
            System.out.println(mas[i].getBook(1));
        }
        ChildrenLibrary lib = new ChildrenLibrary(mas);//поместили массив в библеотеку


        for (int i = 0; i < lib.getCountBooks(); i++) {

            String naz, avt;
            int voz;
            if (i % 2 == 0) {
                naz = "LIBRARY ";
                avt = "Petrov";
                voz = 6;
            } else {
                naz = "UCHEBNIC";
                avt = "Ivanov";
                voz = 12;
            }

                ChildrenBook book = new ChildrenBook(avt, naz, (i + 1) * 50, 1900 + (i  + 1), voz);
                lib.changeBook(i,  book);
        }
        vivod(lib);

        //добавление книги
        System.out.println("=========================================== добавление книги");
        ChildrenBook book=new ChildrenBook("Chehov","nazv",4000,2001,16);

        lib.addBook(11,book);
        vivod(lib);

        //замена книги
        System.out.println("=========================================== замена книги");
        ChildrenBook book1=new ChildrenBook("Chehov","RASCAZ",2400,2021,12);
        lib.changeBook(3,book1);
        vivod(lib);

        //замена зала
        System.out.println("=========================================== замена зала");
        ChildrenLibraryHall hal=new ChildrenLibraryHall("6+",5);
        for(int i=0;i<hal.getCountBooks();i++){
            String naz, avt;
            int voz=12;
            avt = "Socolov";
            naz = "Enceclop ";

            ChildrenBook book2 = new ChildrenBook(avt, naz, (  i + 1) * 100, 2000 + (i  + 1), voz);
            hal.changeBook(i,book2);

        }
        lib.changeHall(3,hal);
        vivod(lib);

        //удаление книги
        System.out.println("=========================================== удаление книги");
        lib.delBook(21);
        vivod(lib);

        //вывод автора самой лучшей книги
        System.out.println();
        System.out.print("Автор самой лучшей книги: ");
        System.out.println(lib.getBestBook().getAuthor());



        //вывод отсортированного массива
        System.out.println("Отсортированный по убыванию список названий книг:");
        ChildrenBook[]masbb=lib.getSortMas();
        for (int i=0;i<masbb.length;i++) {
            System.out.println(masbb[i].getPrice() + "\t" + masbb[i].getName());
        }


    }
    public static void vivod(ChildrenLibrary lib){
        System.out.println();
        System.out.println("№"+"\t"+"автор"+"\t"+"название"+"\t"+"стоимость"+"\t"+"год здания");
        for(int i=0;i<lib.getCountBooks();i++){
            ChildrenBook bok = lib.getBook(i);
            System.out.println(i+"\t"+bok.getAuthor() + "\t" + bok.getName() + "\t" + bok.getPrice() + "\t    " + bok.getYear());
        }
    }
}
