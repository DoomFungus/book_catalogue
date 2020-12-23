package edu.kpi.book_reader.book_catalogue.repository;

import edu.kpi.book_reader.book_catalogue.model.Author;
import edu.kpi.book_reader.book_catalogue.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Optional<Book> findByName(String name);
    Collection<Book> findAllByAuthors(Author author);
    Page<Book> findAll(Pageable page);
}
