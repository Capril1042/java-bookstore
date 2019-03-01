package com.cjs.bookstore.controller;

import com.cjs.bookstore.model.Authors;
import com.cjs.bookstore.model.Book;
import com.cjs.bookstore.model.Section;
import com.cjs.bookstore.repository.AuthorRepository;
import com.cjs.bookstore.repository.BookRepository;
import com.cjs.bookstore.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BookstoreController
{
    @Autowired
    AuthorRepository authorsrepos;

    @Autowired
    SectionRepository sectrepos;

    @Autowired
    BookRepository bookrepos;

    //TODO add custom swagger
    @GetMapping("/books")
        public List<Book> getAllBooks()
    {
        return bookrepos.findAll();
    }

    //TODO add custom swagger
    @GetMapping("/authors")
    public List<Authors> getAllAuthors()
    {
        return authorsrepos.findAll();
    }

    //TODO add custom swagger
    @GetMapping("/sections")
    public List<Section> getAllSections()
    {
        return sectrepos.findAll();
    }
}
