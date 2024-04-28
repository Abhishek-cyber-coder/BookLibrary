package com.nao.booklibrary.service;




import com.nao.booklibrary.model.Book;
import com.nao.booklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBook(id);
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        return bookRepository.save(book);
    }

    @Override
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true; // Book successfully deleted
        }
        return false; // Book not found or unable to delete
    }
}

