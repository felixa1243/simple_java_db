package models;

import utils.generator.MakeBookCode;

public class Magazine extends Book implements MakeBookCode {
    public static int nextCounter = 1;
    private Due due;
    private int counter;

    public Magazine(String title, String publishedYear, String writerName) {
        super(title, publishedYear, writerName);
        this.counter = nextCounter;
        nextCounter++;
        this.bookCode = generate(this);
        this.type = "Magazine";
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
        return getPublishedYear() + "-" + "B" + "-" + this.counter;
    }

    @Override
    public String toString() {
        return "Magazine{" + "title='" + title + '\'' + ", id=" + id + ", publishedYear='" + publishedYear + '\'' + ", writerName='" + writerName + '\'' + ", bookCode='" + bookCode + '\'' + '}';
    }
}
