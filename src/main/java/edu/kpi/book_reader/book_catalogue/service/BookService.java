package edu.kpi.book_reader.book_catalogue.service;

import edu.kpi.book_reader.book_catalogue.model.Author;
import edu.kpi.book_reader.book_catalogue.model.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Integer id);

    Collection<Book> findAllByPage(int pageNumber, int pageSize);

    Optional<Book> findByName(String name);

    void createBook(Book book) throws IllegalArgumentException;
}
