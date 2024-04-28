package com.nao.booklibrary.repository;

import com.nao.booklibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
