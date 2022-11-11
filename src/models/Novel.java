package models;

import utils.generator.GenerateNovelCode;

public class Novel extends Book{
    private final String bookCode;
    public Novel(String title, Integer id, String publishedYear, String writerName) {
        super(title, id, publishedYear, writerName);
        this.bookCode = GenerateNovelCode.generate(this);
    }
}
