package edu.kpi.book_reader.book_catalogue.repository;

import edu.kpi.book_reader.book_catalogue.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Optional<Author> findByName(String name);
}
