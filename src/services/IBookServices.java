package services;

import models.Book;
import responses.Responses;

import java.util.ArrayList;
import java.util.List;

public interface IBookServices {
    Responses addBook(Book book);
    Responses deleteBook(Integer id);
    Book searchBookById(Integer id);
    List<Book> searchBookByTitle(String title);
    ArrayList<Book> getAllBook();
}
