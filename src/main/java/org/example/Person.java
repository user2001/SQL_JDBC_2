package org.example;

public class Person {
    private int person_id;
    private int age;
    private String name;
    private String surname;
    private String email;
    private int book_credit;

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBook_credit(int book_credit) {
        this.book_credit = book_credit;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", book_credit=" + book_credit +
                '}';
    }
}
