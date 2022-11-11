package services;

import models.Book;
import responses.Responses;

import java.util.ArrayList;

public interface IBookServices {
    Responses addBook(Book book);
    void deleteBook(Integer id);
    Book searchBookById(Integer id);
    ArrayList<Book> getAllBook();
}
