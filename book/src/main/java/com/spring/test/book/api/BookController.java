package com.spring.test.book.api;

import com.spring.test.book.resource.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    // get all books
    @GetMapping
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }


    // get book by id
    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId){
        return bookService.findBookById(bookId);
    }

    // post new book
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    // delete book by id
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }

    // put updated book
    @PutMapping("/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long bookId){
        return bookService.updateBook(book, bookId);
    }

}
