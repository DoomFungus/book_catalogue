package edu.kpi.book_reader.book_catalogue.service.impl;

import edu.kpi.book_reader.book_catalogue.model.Author;
import edu.kpi.book_reader.book_catalogue.repository.AuthorRepository;
import edu.kpi.book_reader.book_catalogue.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public void createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        try {
            authorRepository.save(author);
        } catch (Exception e){
            throw new IllegalArgumentException("Could not create author");
        }
    }
}
