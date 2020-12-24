package edu.kpi.book_reader.book_catalogue.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.kpi.book_reader.book_catalogue.model.Author;
import edu.kpi.book_reader.book_catalogue.model.Book;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class BookInputMessage {
    @JsonProperty
    private String name;
    @JsonProperty
    private String summary;
    @JsonProperty
    private Collection<String> authors;

    public Book toBook(){
        Book book = new Book();
        book.setName(name);
        book.setSummary(summary);
        List<Author> authorList = new ArrayList<>();
        for(String authorName: authors){
            Author author = new Author();
            author.setName(authorName);
            authorList.add(author);
        }
        book.setAuthors(authorList);
        return book;
    }
}
