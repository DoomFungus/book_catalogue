package edu.kpi.book_reader.book_catalogue.service;

import edu.kpi.book_reader.book_catalogue.model.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Integer id);

    Optional<Author> findByName(String name);

    void createAuthor(String name) throws IllegalArgumentException;
}
