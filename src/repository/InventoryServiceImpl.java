package repository;

import models.Book;
import responses.Responses;
import responses.SuccessStatus;
import utils.exceptions.EmptyListException;
import utils.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService {

    private final ArrayList<Book> books;

    public InventoryServiceImpl(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public Responses pushBack(Book book) {
        if (book.toString().isBlank()) {
            throw new ValidationException();
        }
        books.add(book);
        return new SuccessStatus("Add book success");
    }

    @Override
    public Responses delete(Integer id) {
        if (getAll() == null) {
            throw new ValidationException();
        }
        books.remove(id);
        return new SuccessStatus("Delete success");
    }

    @Override
    public Book searchByid(Integer id) {
        var results = books.stream().filter(book -> book.getId().equals(id)).collect(Collectors.toList());
        if (results.size() < 1) {
            throw new EmptyListException();
        }
        return results.get(0);
    }

    @Override
    public ArrayList<Book> getAll() {
        if (books.size() < 1) {
            return null;
        }
        return books;
    }

    @Override
    public List<Book> searchByTitle(String title) {

        var results = books.stream().filter(book -> book.getTitle().toLowerCase().equals(title.toLowerCase())).collect(Collectors.toList());
        if (results.size() < 0) {
            throw new EmptyListException();
        }
        return results;
    }
}
