package models;

import utils.generator.MakeBookCode;

public class Magazine extends Book implements MakeBookCode {
    private Due due;
    private int counter = 0;
    public Magazine(String title, Integer id, String publishedYear, String writerName, Due due) {
        super(title, id, publishedYear, writerName);
        this.due = due;
        this.bookCode = this.generate(this);
        this.counter++;
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
