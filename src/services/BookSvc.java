package services;

import models.Book;
import repository.InventoryServiceImpl;
import responses.Responses;

import java.util.ArrayList;
import java.util.List;

public class BookSvc implements IBookServices  {
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl(new ArrayList<>());

    @Override
    public Responses addBook(Book book) {
        return inventoryServiceImpl.pushBack(book);
    }

    @Override
    public Responses deleteBook() {
        return inventoryServiceImpl.delete();
    }

    @Override
    public Book searchBookById(String id) {
        return inventoryServiceImpl.searchByid(id);
    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        return inventoryServiceImpl.searchByTitle(title);
    }

    @Override
    public List<Book> getAllBook() {
        return inventoryServiceImpl.getAll();
    }
}
