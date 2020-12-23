package edu.kpi.book_reader.book_catalogue.controller;

import edu.kpi.book_reader.book_catalogue.message.BookInputMessage;
import edu.kpi.book_reader.book_catalogue.message.BookOutputMessage;
import edu.kpi.book_reader.book_catalogue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void saveBook(@RequestBody BookInputMessage message){
        try {
            bookService.createBook(message.toBook());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create book");
        }
    }

    @GetMapping("/{id}")
    public BookOutputMessage findBook(@PathVariable("id") Integer id){
        return BookOutputMessage
                .fromBook(bookService
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find book")));
    }

    @GetMapping
    public Collection<BookOutputMessage> findBooksByPage(@RequestParam("page_number") Integer pageNumber,
                                                         @RequestParam("page_size") Integer pageSize){
        return bookService
                .findAllByPage(pageNumber, pageSize)
                .stream()
                .map(BookOutputMessage::fromBook)
                .collect(Collectors.toList());
    }
}
