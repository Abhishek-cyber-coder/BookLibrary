package com.nao.booklibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please provide the book title")
    @Size(max = 100, message = "Book title length should not be longer than 100 char")
    private String title;

    @Pattern(regexp = "^\\d{3}-\\d{10}$|^\\d{13}$", message = "ISBN must be in valid format")
    private String isbn;

    @NotNull(message = "Publication year is required")
    private int publicationYear;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Rental rental;

    // Constructors, getters, and setters

    public Book() {
    }

    public Book(String title, String isbn, int publicationYear, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

