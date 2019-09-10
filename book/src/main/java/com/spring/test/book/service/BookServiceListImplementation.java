package com.spring.test.book.service;

import com.spring.test.book.api.BookService;
import com.spring.test.book.resource.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookServiceListImplementation implements BookService {

    private List<Book> bookList = new ArrayList<>();


    @Override
    public Book findBookById(final long bookId){
        return bookList.
                stream().
                filter(
                        (Book b)->
                        b.getId()==bookId
                ).
                findAny().
                orElse(null);
    }

    @Override
    public List<Book> findAllBooks(){
        return new ArrayList<>(bookList);
    }

    @Override
    public Book createBook(Book book){

        bookList.add(book);

        int index = 0;
        if ((index=bookList.indexOf(book))!=-1){
            return bookList.get(index);
        } else
            return null;
    }

    @Override
    public void deleteBook(long bookId){
        Book returnBook = bookList.
                stream().
                filter(
                        (Book b)->
                                b.getId()==bookId
                ).
                findAny().
                orElse(null);
        bookList.remove(returnBook);
    }

    @Override
    public Book updateBook(Book book, long bookId){
        deleteBook(bookId);
        return createBook(book);
    }

}
