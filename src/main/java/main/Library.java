package main;

import java.util.ArrayList;

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kirja lisätty kirjastoon!");
    }

    public void listBooks() {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("Kirjan kategoria: " + book.categorize());
        }
        System.out.println("Kirjojen määrä kirjastossa on: " + books.size());
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}