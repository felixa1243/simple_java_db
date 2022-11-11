package models;

import utils.generator.MakeBookCode;

public class Novel extends Book implements MakeBookCode {
    private int counter;
    public Novel(String title, Integer id, String publishedYear, String writerName) {
        super(title, id, publishedYear, writerName);
        this.counter+=1;
    }

    @Override
    public String generate(Book book) {
        return this.getPublishedYear()+"-"+"A"+"-"+this.counter;
    }
}
