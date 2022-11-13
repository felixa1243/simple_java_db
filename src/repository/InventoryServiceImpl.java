package repository;

import models.Book;
import models.Magazine;
import models.Novel;
import responses.Responses;
import responses.SuccessStatus;
import utils.exceptions.EmptyListException;
import utils.exceptions.ValidationException;

import java.io.FileWriter;
import java.io.IOException;
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
    private final Path file;

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


    @Override
    public Responses pushBack(Book book) {
        if (book.toString().isBlank()) {
            throw new ValidationException();
        }
        books.add(book);
        try {
            var results = book.getTitle() + "||" + book.getId() + "||" + book.getPublishedYear() + "||" + book.getWriterName() + "||" + book.getType() + "||" + book.getBookCode() + "\n";
            Files.write(file, results.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }

        return new SuccessStatus("Add book success");
    }

    @Override
    public Responses delete() {
        try {
            var results = getAll();
            var size = results.size();
            if (size < 1) {
                throw new EmptyListException();
            }
            FileWriter writer = new FileWriter(file.toFile());
            results.remove(size - 1);
            for (var str : results) {
                writer.write(str + "||" + "\n");
            }
            writer.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
        return new SuccessStatus("Delete success");
    }

    @Override
    public Book searchByid(String id) {
        var results = getAll().stream().filter(book -> book.getId().equalsIgnoreCase(id)).collect(Collectors.toList());
        System.out.println(results);
        if (results.size() < 1) {
            throw new EmptyListException();
        }
        return results.get(0);
    }
    @Override
    public List<Book> searchByTitle(String title) {

        var results = getAll().stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
        if (results.size() < 0) {
            throw new EmptyListException();
        }
        return results;
    }
    @Override
    public List<Book> getAll() {
        List<Book> lines = null;
        try {
            lines = Files.lines(file).map(member -> {
                String[] arr = member.split("\\|\\|");
                return arr[4].equals("Novel") ? new Novel(arr[0], arr[2], arr[3]) : new Magazine(arr[0], arr[2], arr[3]);
            }).collect(Collectors.toList());
        } catch (IOException err) {
            err.printStackTrace();
        }
        return lines;
    }
}
