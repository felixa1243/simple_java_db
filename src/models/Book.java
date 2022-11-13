package models;

import java.util.UUID;

public class Book {
    protected String title;
    protected String id;
    protected String publishedYear;
    protected String writerName;
    protected String bookCode;
    protected String type;

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBookCode() {
        return bookCode;
    }

    public Book(String title, String publishedYear, String writerName) {
        this.title = title;
        this.id = UUID.randomUUID().toString();
        this.publishedYear = publishedYear;
        this.writerName = writerName;
    }

    public String getWriterName() {
        return writerName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", publishedYear='" + publishedYear + '\'' +
                ", writerName='" + writerName + '\'' +
                ", bookCode='" + bookCode + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }
}
