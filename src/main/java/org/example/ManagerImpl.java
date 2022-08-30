package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerImpl implements Manager {
    public static final String SQL_SELECT = "SELECT * FROM Person ORDER BY Person.person_id";
    public static final String SQL_SELECT_WHERE_AMOUNT = "SELECT * FROM Book where amount>30";
    public static final String SQL_LEFT_JOIN = "SELECT * FROM Person  LEFT JOIN Book ON Person.book_credit=Book.book_id ORDER BY Person.name";
    public static final String SQL_AUTHOR = "SELECT * FROM Book WHERE author=?";
    public static final String SQL_AGE = "SELECT * FROM Person WHERE age>=?";

    // First
    @Override
    public void infoAllPersons() {
        System.out.println("Info about all persons in data:");
        try {
            Statement statement = ConnectionManager.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);
            setPersonInfo(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("------------------------------------");
    }

    // Second
    @Override
    public void booksAmountMoreThan30() {
        System.out.println("There are books amount of which more than 30:");
        try {
            Statement statement = ConnectionManager.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_WHERE_AMOUNT);
            setBookInfo(resultSet);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        System.out.println("------------------------------------");
    }

    //Third
    @Override
    public void showPersonsBook() {
        System.out.println("There are data about what book each person reads:");
        try {
            Statement statement = ConnectionManager.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_LEFT_JOIN);

            while (resultSet.next()) {
                int person_id = resultSet.getInt("person_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                System.out.println(person_id + " " + name + " " + " " + surname + " reads " + title + " written by " + author);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        System.out.println("------------------------------------");
    }

    // Fourth
    @Override
    public void selectBookByAuthor() {
        System.out.println("Books written by Frederik Backman:");
        try {
            PreparedStatement preparedStatement = ConnectionManager.connection.prepareStatement(SQL_AUTHOR);
            preparedStatement.setString(1, "Backman Frederik");
            ResultSet resultSet = preparedStatement.executeQuery();
            setBookInfo(resultSet);
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("------------------------------------");
    }

    // Fifth
    @Override
    public void getPersonWhereAgeMore30() {
        System.out.println("There are persons with age more than 30:");
        try {
            PreparedStatement preparedStatement = ConnectionManager.connection.prepareStatement(SQL_AGE);
            preparedStatement.setInt(1, 30);
            ResultSet resultSet = preparedStatement.executeQuery();
            setPersonInfo(resultSet);
            resultSet.close();
            preparedStatement.close();
            ConnectionManager.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPersonInfo(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Person person = new Person();
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setSurname(resultSet.getString("surname"));
            person.setEmail(resultSet.getString("email"));
            person.setPerson_id(resultSet.getInt("person_id"));
            person.setBook_credit(resultSet.getInt("book_credit"));
            System.out.println(person);
        }
    }

    public void setBookInfo(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Book book = new Book();
            book.setBook_id(resultSet.getInt("book_id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setAmount(resultSet.getInt("amount"));
            System.out.println(book);
        }
    }

}
