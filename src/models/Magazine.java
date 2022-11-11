package models;

import utils.generator.GenerateMagazineCode;

public class Magazine extends Book{
    private final String bookCode;
    private Due due;

    public Magazine(String title, Integer id, String publishedYear, String writerName, String bookCode, Due due) {
        super(title, id, publishedYear, writerName);
        this.bookCode = GenerateMagazineCode.generate(this);
        this.due = due;
    }
}
