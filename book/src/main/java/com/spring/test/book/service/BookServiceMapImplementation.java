package com.spring.test.book.service;

import com.spring.test.book.api.BookService;
import com.spring.test.book.resource.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class BookServiceMapImplementation implements BookService {

    private Map<Long, Book> books= new HashMap<>();

    @Override
    public Book findBookById(long bookId) {
        return books.get(bookId);
    }

    @Override
    public List<Book> findAllBooks() {
        return new ArrayList<Book>(books.values());
    }

    @Override
    public Book createBook(Book book) {
        return books.putIfAbsent(book.getId(), book);
    }

    @Override
    public void deleteBook(long bookId) {
        books.remove(bookId);
    }

    @Override
    public Book updateBook(Book book, long bookId) {
        return books.replace(bookId, book);
    }
}
