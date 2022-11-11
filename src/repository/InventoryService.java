package repository;

import models.Book;
import responses.Responses;

import java.util.List;

public interface InventoryService {
    Responses pushBack(Book book);
    Responses delete(Integer id);
    Book searchByid(Integer id);
    List<Book> searchByTitle(String title);
    List<Book> getAll();
}
