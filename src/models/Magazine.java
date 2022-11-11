package models;

import utils.generator.MakeBookCode;

public class Magazine extends Book implements MakeBookCode {
    private Due due;
    private int counter;
    public static int nextCounter = 1;
    public Magazine(String title, String id, String publishedYear, String writerName) {
        super(title, id, publishedYear, writerName);
        this.bookCode = this.generate(this);
        this.counter = this.nextCounter;
        this.nextCounter++;
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
        return this.getPublishedYear()+"-"+"B"+"-"+this.counter;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", publishedYear='" + publishedYear + '\'' +
                ", writerName='" + writerName + '\'' +
                ", bookCode='" + bookCode + '\'' +
                '}';
    }
}
