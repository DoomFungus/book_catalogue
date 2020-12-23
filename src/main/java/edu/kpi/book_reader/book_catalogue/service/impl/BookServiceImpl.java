package edu.kpi.book_reader.book_catalogue.service.impl;

import edu.kpi.book_reader.book_catalogue.model.Author;
import edu.kpi.book_reader.book_catalogue.model.Book;
import edu.kpi.book_reader.book_catalogue.repository.BookRepository;
import edu.kpi.book_reader.book_catalogue.service.AuthorService;
import edu.kpi.book_reader.book_catalogue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Collection<Book> findAllByPage(int pageNumber, int pageSize) {
        return bookRepository
                .findAll(PageRequest
                        .of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id"))).toList();
    }

    @Override
    public Optional<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public void createBook(Book book) {
        ArrayList<Author> authors = new ArrayList<>();
        for(Author author: book.getAuthors()){
            authorService.findByName(author.getName()).ifPresentOrElse(authors::add, () -> {
                authorService.createAuthor(author.getName());
                authorService.findByName(author.getName()).ifPresent(authors::add);
            });
        }
        book.setAuthors(authors);
        try {
            bookRepository.save(book);
        } catch (Exception e){
            throw new IllegalArgumentException("Could not create book");
        }
    }
}
