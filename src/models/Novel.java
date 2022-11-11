package models;

import utils.generator.MakeBookCode;

public class Novel extends Book implements MakeBookCode {
    private int counter;
    public static int nextCounter = 1;
    public Novel(String title, String id, String publishedYear, String writerName) {
        super(title, id, publishedYear, writerName);
        this.counter = nextCounter;
        this.nextCounter++;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", publishedYear='" + publishedYear + '\'' +
                ", writerName='" + writerName + '\'' +
                ", bookCode='" + bookCode + '\'' +
                '}';
    }

    @Override
    public String generate(Book book) {
        return this.getPublishedYear()+"-"+"A"+"-"+this.counter;
    }
}
