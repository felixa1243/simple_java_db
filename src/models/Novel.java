package models;

import utils.generator.MakeBookCode;

public class Novel extends Book implements MakeBookCode {
    public static int nextCounter = 1;
    private final int counter;

    public Novel(String title, String publishedYear, String writerName) {
        super(title, publishedYear, writerName);
        this.bookCode = generate(this);
        this.counter = nextCounter;
        nextCounter++;
    }

    @Override
    public String toString() {
        return "Novel{" + "title='" + title + '\'' + ", id=" + id + ", publishedYear='" + publishedYear + '\'' + ", writerName='" + writerName + '\'' + ", bookCode='" + bookCode + '\'' + '}';
    }

    @Override
    public String generate(Book book) {
        return this.getPublishedYear() + "-" + "A" + "-" + this.counter;
    }
}
