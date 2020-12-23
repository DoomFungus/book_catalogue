package edu.kpi.book_reader.book_catalogue.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.kpi.book_reader.book_catalogue.model.Author;
import edu.kpi.book_reader.book_catalogue.model.Book;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookOutputMessage {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String summary;
    @JsonProperty
    private Collection<String> authors;

    public static BookOutputMessage fromBook(Book book){
        BookOutputMessage message = new BookOutputMessage();
        message.setId(book.getId());
        message.setName(book.getName());
        message.setSummary(book.getSummary());
        message.authors = new ArrayList<>();
        for(Author author: book.getAuthors()){
            message.authors.add(author.getName());
        }
        return message;
    }
}
