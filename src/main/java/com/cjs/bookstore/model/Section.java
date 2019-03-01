package com.cjs.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "section")
public class Section
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long section;

    private String name;

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnore
    private Book book;

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

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }
}
