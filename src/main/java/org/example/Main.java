package org.example;

public class Main {
    public static void main(String[] args) {
        ManagerImpl manager = new ManagerImpl();
        manager.infoAllPersons();
        manager.booksAmountMoreThan30();
        manager.showPersonsBook();
        manager.selectBookByAuthor();
        manager.getPersonWhereAgeMore30();

    }

}
