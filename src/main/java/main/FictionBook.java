package main;

class FictionBook extends Book implements Borrowable {
    private int borrowedCopies;

    public FictionBook(String title, String author, int pages, int copies) {
        super(title, author, pages, copies);
        this.borrowedCopies = 0;
    }

    public String categorize() {
        return "Fiktiokirja";
    }

    @Override
     
    public void borrow() {
        if (copies < 1) {
            System.out.println("Kirjaa " + title + " ei enään ole lainattavissa!");
        } else {
            copies --;
            borrowedCopies ++;
            System.out.println("Kirja" + title + "on nyt lainattu.");
        }
    }

    @Override
    public void returnBook() {
        if (borrowedCopies > 0) {
            copies++;
            borrowedCopies--;
            System.out.println("Kirja " + title + " on palautettu.");
        } else {
            System.out.println("Kirja " + title + " ei ole lainassa.");
        }
    }
}