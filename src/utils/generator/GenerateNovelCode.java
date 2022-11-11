package utils.generator;

import models.Book;

public abstract class GenerateNovelCode {
    public static String generate(Book book){
        MakeBookCode generate = (item)->{
            var published = item.getPublishedYear();
            return published+"A"+"1";
        };
        return generate.generate(book);
    }
}
