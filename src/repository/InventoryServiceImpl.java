package repository;

import exceptions.Error;
import models.Book;
import responses.FailStatus;
import responses.Responses;
import responses.SuccessStatus;

import java.util.ArrayList;

public class InventoryServiceImpl implements InventoryService {

    private final ArrayList<Book> books;

    public InventoryServiceImpl(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public Responses pushBack(Book book) {
       if(book.toString().isBlank()){
           return new FailStatus("Name can't be blank",Error.EMPTY_NAME);
       }
       books.add(book);
       return new SuccessStatus("Add book success");
    }

    @Override
    public Responses delete(Integer id) {
        if(getAll() == null){
            return new FailStatus("Empty List",Error.EMPTY_LIST);
        }
        books.remove(id);
        return new SuccessStatus("Delete success");
    }

    @Override
    public Book searchByid(Integer id) {
        if(id >= books.size()){
            return null;
        }
        return books.get(id);
    }

    @Override
    public ArrayList<Book> getAll() {
        if(books.size() < 1){
            return null;
        }
        return books;
    }
}
