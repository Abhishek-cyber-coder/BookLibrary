package com.nao.booklibrary.service;

import com.nao.booklibrary.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBook(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id, Book bookDetails);
    boolean deleteBook(Long id);

}

