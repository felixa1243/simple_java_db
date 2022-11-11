import models.Book;
import models.Due;
import models.Magazine;
import models.Novel;
import services.BookSvc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends BookSvc {
    public static void main(String[] args) {
        BookSvc service = new BookSvc();
//        var status = service.addBook(new Book("Harry potter", 1, "2019", "Maroon five"));
//        System.out.println(status.getMessage());
//        System.out.println(service.getAllBook());
////        System.out.println(service.deleteBook(0).getMessage());
//        System.out.println(service.getAllBook());
//        System.out.println(service.searchBookByTitle("harry potter"));
//        System.out.println(service.searchBookById(1));

        service.addBook(new Magazine("Harry potter and magician","1","2019","helga"));
        service.addBook(new Magazine("Harry potter and magician","2","2019","helga"));
        service.addBook(new Novel("Harry potter and magician","3","2019","helga"));
        System.out.println(service.getAllBook());
    }
}