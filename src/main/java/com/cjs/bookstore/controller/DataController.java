package com.cjs.bookstore.controller;

import com.cjs.bookstore.model.Book;
import com.cjs.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/data/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController
{
    @Autowired
    BookRepository booksrepo;


    //TODO Test this endpoint
    @PutMapping("/books/{id}")
    public Book changeBookById(@RequestBody Book newbook, @PathVariable long id) throws URISyntaxException
    {
        Optional<Book> updateBook = booksrepo.findById(id);
        if (updateBook.isPresent())
        {
            if (newbook.getBooktitle() == null)
            {
                newbook.setBooktitle(updateBook.get().getBooktitle());
            }

            if (newbook.getCopy()== 0)
            {
                newbook.setCopy(updateBook.get().getCopy());
            }
            if (newbook.getISBN()== null)
            {
                newbook.setISBN(updateBook.get().getISBN());
            }
            if (newbook.getAuthors()== null)
            {
                newbook.setAuthors(updateBook.get().getAuthors());
            }
            newbook.setBookid(id);
            booksrepo.save(newbook);

            return newbook;
        }
        else
        {
            return null;
        }
    }
//    POST /books/authors{id} - assigns a book already in the system to an author already in the system


    //TODO test this endpoint
    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable long id)
    {
        Optional<Book> foundBook = booksrepo.findById(id);
        if (foundBook.isPresent())
        {
            booksrepo.deleteById(id);

            return "{" + "\"bookid\":" + foundBook.get().getBookid() +
                    ",\"bookname\":" + "\"" + foundBook.get().getBooktitle() + "\"" +
                    "}";
        } else
        {
            return null;
        }
    }

}
