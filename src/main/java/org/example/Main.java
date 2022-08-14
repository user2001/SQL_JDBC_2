package org.example;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.infoAllPersons();
        manager.booksAmountMoreThan30();
        manager.showPersonsBook();
        manager.selectBookByAuthor();
        manager.getPersonWhereAgeMore30();
    }

}
