package com.nao.booklibrary.service;

import com.nao.booklibrary.model.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    Author getAuthor(Long id);
    List<Author> getAuthors();
    Author updateAuthor(Long id,Author authorDetails);
    boolean deleteAuthor(Long id);
}
