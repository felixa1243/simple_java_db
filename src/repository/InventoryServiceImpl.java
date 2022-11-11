package repository;

import models.Book;
import responses.Responses;
import responses.SuccessStatus;
import utils.exceptions.EmptyListException;
import utils.exceptions.ValidationException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService {
    private final ArrayList<Book> books;
    private Path file;

    public InventoryServiceImpl(ArrayList<Book> books) {
        this.books = books;
        file = Paths.get("/home/user/project/livecode/src/data/db.txt");
        try {
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
        } catch (IOException err) {
            System.out.println(err);
        }
    }

    private static Book createBook(String[] metadata) {
        String title = metadata[0];
        String id = metadata[1];
        String publishedYear = metadata[2];
        String writterName = metadata[3];
        return new Book(title, id, publishedYear, publishedYear);
    }

    @Override
    public Responses pushBack(Book book) {
        if (book.toString().isBlank()) {
            throw new ValidationException();
        }
        books.add(book);
        try {
            var results = book.getTitle() +"||" +book.getId()+"||" + book.getPublishedYear()+"||" + book.getWriterName() + "\n";
            Files.write(file, results.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }

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
    public List<Book> getAll() {
        List<Book> lines = null;
//        try (BufferedReader br = Files.newBufferedReader(file)) {
//            String line = br.readLine();
//            while (line != null) {
//                String[] attributes = line.split("\\|\\|");
//                Book book1 = createBook(attributes);
//                lines.add(book1);
//            }
        try{
            lines = Files.lines(file).map(member->{
                String [] arr = member.split("\\|\\|");
                return new Book(arr[0],arr[1],arr[2],arr[3]);
            }).collect(Collectors.toList());
        } catch (IOException err) {
            err.printStackTrace();
        }
        return lines;
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
