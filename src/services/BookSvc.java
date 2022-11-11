package services;

import models.Book;
import repository.InventoryServiceImpl;
import responses.Responses;

import java.util.ArrayList;

public class BookSvc implements IBookServices {
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl(new ArrayList<>());

    @Override
    public Responses addBook(Book book) {
        return inventoryServiceImpl.pushBack(book);
    }

    @Override
    public void deleteBook(Integer id) {
        inventoryServiceImpl.delete(id);
    }

    @Override
    public Book searchBookById(Integer id) {
        return inventoryServiceImpl.searchByid(id);
    }

    @Override
    public ArrayList<Book> getAllBook() {
        return inventoryServiceImpl.getAll();
    }
}
