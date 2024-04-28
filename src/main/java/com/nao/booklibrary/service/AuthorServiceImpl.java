package com.nao.booklibrary.service;

import com.nao.booklibrary.model.Author;
import com.nao.booklibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthor(Long id){
        return authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author not found"));
    }

    @Override
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Long id, Author authorDetails){
        Author author = getAuthor(id);
        author.setName(authorDetails.getName());
        author.setBiography(authorDetails.getBiography());
        return authorRepository.save(author);
    }

    @Override
    public boolean deleteAuthor(Long id){
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
            return true; // Author successfully deleted;
        }
        return false; // Author not found
    }

}
