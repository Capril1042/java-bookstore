package com.cjs.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "section")
public class Section
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long section;

    private String name;

    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties("section")
    private Set<Book> books = new HashSet<>();

    public Section()
    {
    }

    public long getSection()
    {
        return section;
    }

    public void setSection(long section)
    {
        this.section = section;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }
}
