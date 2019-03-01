package com.cjs.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "authors")
public class Authors
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorid;

    private String lastname;

    private String firstname;

    @ManyToMany
    @JoinTable(name = "authorsbooks",
            joinColumns = {@JoinColumn(name ="authorid")},
            inverseJoinColumns = {@JoinColumn(name="bookid")})
    @JsonIgnoreProperties("authors")
    private Set<Book> books =new HashSet<>();

    public Authors()
    {
    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
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
