package com.nao.booklibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Objects;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Renter name is required")
    private String renterName;

    @NotNull(message = "Rental date is required")
    @Temporal(TemporalType.DATE)
    private Date rentalDate;

    @NotNull(message = "Return date is required")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // Constructors, getters, and setters

    public Rental() {
    }

    public Rental(String renterName, Date rentalDate, Date returnDate, Book book) {
        this.renterName = renterName;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

