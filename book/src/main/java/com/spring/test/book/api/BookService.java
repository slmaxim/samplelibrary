package com.spring.test.book.api;

import com.spring.test.book.resource.Book;

import java.util.List;

public interface BookService {
    Book findBookById(long bookId);

    List<Book> findAllBooks();

    Book createBook(Book book);

    void deleteBook(long bookId);

    Book updateBook(Book book, long bookId);
}
