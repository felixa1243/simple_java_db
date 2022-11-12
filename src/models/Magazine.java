package models;

import utils.generator.MakeBookCode;

public class Magazine extends Book implements MakeBookCode {
    public static int nextCounter = 1;
    private Due due;
    private final int counter;

    public Magazine(String title, String publishedYear, String writerName) {
        super(title, publishedYear, writerName);
        this.bookCode = this.generate(this);
        this.counter = nextCounter;
        nextCounter++;
    }

    public Due getDue() {
        return due;
    }

    public Magazine setDue(Due due) {
        this.due = due;
        return this;
    }

    @Override
    public String generate(Book book) {
        return this.getPublishedYear() + "-" + "B" + "-" + this.counter;
    }

    @Override
    public String toString() {
        return "Magazine{" + "title='" + title + '\'' + ", id=" + id + ", publishedYear='" + publishedYear + '\'' + ", writerName='" + writerName + '\'' + ", bookCode='" + bookCode + '\'' + '}';
    }
}
