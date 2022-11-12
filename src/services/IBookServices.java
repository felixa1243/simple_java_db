package services;

import models.Book;
import responses.Responses;

import java.util.List;

public interface IBookServices {
    Responses addBook(Book book);
    Responses deleteBook();
    Book searchBookById(String id);
    List<Book> searchBookByTitle(String title);
    List<Book> getAllBook();
}
