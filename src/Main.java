import models.Book;
import services.BookSvc;

public class Main extends BookSvc {
    public static void main(String[] args) {
        BookSvc service = new BookSvc();
        var status = service.addBook(new Book("Harry potter", 1, "2019", "Maroon five"));
        System.out.println(status.getMessage());
        System.out.println(service.getAllBook());
    }
}