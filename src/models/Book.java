package models;

public class Book {
    private String title;
    private Integer id;
    private String publishedYear;
    private String writerName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Book(String title, Integer id, String publishedYear,String writerName) {
        this.title = title;
        this.id = id;
        this.publishedYear = publishedYear;
        this.writerName = writerName;
    }
}
