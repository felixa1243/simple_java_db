package repository;

import models.Book;
import responses.Responses;

import java.util.ArrayList;

public interface InventoryService {
    Responses pushBack(Book book);
    Responses delete(Integer id);
    Book searchByid(Integer id);
    ArrayList<Book> getAll();
}
