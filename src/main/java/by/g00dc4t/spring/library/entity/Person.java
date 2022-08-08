package by.g00dc4t.spring.library.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Pattern(regexp = "[a-zA-Z]+", message = "name must use letters")
    private String name;

    @Column(name = "surname")
    @Pattern(regexp = "[a-zA-Z]+", message = "surname must use letters")
    private String surName;

    @Column(name = "year")
    @Min(value = 18, message = "must be more than 17")
    @Max(value = 100, message = "must be less than 101")
    private int year;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH},
            mappedBy = ("person"),
            fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private List<Book> books;

    {
        books = new ArrayList<Book>();
    }

    public Person() {
    }

    public Person(String name, String surName, int year) {
        this.name = name;
        this.surName = surName;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return name + " " + surName;
    }
}
