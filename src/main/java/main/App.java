package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {        
        Scanner sc = new Scanner (System.in);
        Library library = new Library();


        boolean exit = false;

        while (!exit) {
            System.out.println("1) Lisää kirja");
            System.out.println("2) Listaa kirjat");
            System.out.println("3) Lainaa fiktiokirja");
            System.out.println("4) Palauta fiktiokirja");
            System.out.println("0) Lopeta ohjelma");

            if (sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch (i) {
                    case 1: 
                        System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");
                        int bookType = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Anna kirjan nimi:");
                        String title = sc.nextLine();
                        System.out.println("Anna kirjailijan nimi:");
                        String author = sc.nextLine();
                        System.out.println("Anna sivumäärä:");
                        int pages = Integer.parseInt(sc.nextLine()); 
                        System.out.println("Anna kirjojen määrä:");
                        int copies = Integer.parseInt(sc.nextLine());

                        if (bookType == 1) {
                            library.addBook(new FictionBook(title, author, pages, copies));
                        } else if (bookType == 2) {
                            library.addBook(new NonFictionBook(title, author, pages, copies));
                        } else {
                            System.out.println("Virheellinen kirjatyyppi.");
                        }
                        break;
         
                    case 2:
                       library.listBooks();

                       break;
                    
                    case 3:
                       System.out.println("Anna lainattavan kirjan nimi:");
                       String borrowTitle = sc.nextLine();
                       boolean foundBorrow = false;
   
                       for (Book book : library.getBooks()) {
                           if (book instanceof FictionBook && book.title.equals(borrowTitle)) {
                               ((FictionBook) book).borrow();
                               foundBorrow = true;
                               break;
                           }
                       }
   
                       if (!foundBorrow) {
                           System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
                       }
                       break;

                    case 4:
                        System.out.println("Anna palautettavan kirjan nimi:");
                        String returnTitle = sc.nextLine();
                        boolean foundReturn = false;
    
                        for (Book book : library.getBooks()) {
                            if (book instanceof FictionBook && book.title.equals(returnTitle)) {
                                ((FictionBook) book).returnBook();
                                foundReturn = true;
                                break;
                            }
                        }
    
                        if (!foundReturn) {
                            System.out.println("Kirjaa ei löytynyt tai sitä ei voi palauttaa.");
                        }
                        break;

    

                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;

                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }
        }
        sc.close();
    }
}
