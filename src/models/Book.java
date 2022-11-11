package models;

public class Book {
    protected String title;
    protected String id;
    protected String publishedYear;
    protected String writerName;

    public String getWriterName() {
        return writerName;
    }

    protected String bookCode;
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", id=" + id +
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

    public Book(String title, String id, String publishedYear, String writerName) {
        this.title = title;
        this.id = id;
        this.publishedYear = publishedYear;
        this.writerName = writerName;
    }
}
