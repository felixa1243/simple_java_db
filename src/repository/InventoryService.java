package repository;

import models.Book;
import responses.Responses;

import java.util.List;

public interface InventoryService {
    Responses pushBack(Book book);

    Responses delete();

    Book searchByid(String id);

    List<Book> searchByTitle(String title);

    List<Book> getAll();
}
