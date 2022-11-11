package utils.generator;

import models.Book;

public abstract class GenerateMagazineCode {
   public static String generate(Book book) {
       MakeBookCode generate = (item) -> {
           var published = item.getPublishedYear();
           var bookname = item.getTitle();
           return published +"B"+ "1";
       };
       return generate.generate(book);
    }
}
