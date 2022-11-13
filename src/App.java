import models.Due;
import models.Magazine;
import models.Novel;
import services.BookSvc;
import utils.exceptions.EmptyListException;
import utils.exceptions.ValidationException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App extends BookSvc {
    public static void main(String[] args) {
        BookSvc service = new BookSvc();
        Scanner scanner = new Scanner(System.in);
        var condition = true;
        while (condition) {

            System.out.println("ENIGPUS...");
            System.out.println("1.Add book");
            System.out.println("2.Search book");
            System.out.println("3.Remove book");
            System.out.println("4.List book");
            System.out.println("5.exit");
            var opt = scanner.next();
            if (!opt.matches("[1-5]")) {
                System.err.println("Options only 1-5");
            }
            if (opt.equals("1")) {

                System.out.println("Input Published year :");
                var publishedYear = scanner.next();
                scanner.nextLine();
                while (!publishedYear.matches("\\d+")) {
                    System.out.println("Invalid year!");
                    System.out.println("Input Published year:");
                    publishedYear = scanner.next();
                    scanner.nextLine();
                }
                System.out.println("Input Book title :");
                var title = scanner.nextLine();
                System.out.println("Input Writter name: ");
                var writterName = scanner.nextLine();
                System.out.println("Category: ");
                System.out.println("1.Novel ");
                System.out.println("2.Magazine ");
                var opt1 = scanner.next();
                scanner.nextLine();
                while (!opt1.matches("[1-2]")) {
                    System.out.println("Invalid options [1-2]");
                    System.out.println("Category: ");
                    System.out.println("1.Novel ");
                    System.out.println("2.Magazine ");
                    opt1 = scanner.next();
                    scanner.nextLine();
                }
                try {
                    if (opt1.equals("1")) {
                        Novel novel = new Novel(title, publishedYear, writterName);
                        System.out.println(service.addBook(novel).getMessage());
                    } else {
                        Due due = null;
                        Magazine magazine = new Magazine(title, publishedYear, writterName);
                        int dueOpt;
                        try {
                            System.out.println("1.Monthly");
                            System.out.println("2.Weekly");
                            dueOpt = scanner.nextInt();
                            scanner.nextLine();
                            while (!(dueOpt < 2)) {
                                System.err.println("Options only 1-2");
                                System.out.println("1.Monthly");
                                System.out.println("2.Weekly");
                                dueOpt = scanner.nextInt();
                                scanner.nextLine();
                            }
                            if (dueOpt == 1) {
                                due = Due.MONTHLY;
                            } else {
                                due = Due.WEEKLY;
                            }
                            magazine.setDue(due);
                        } catch (InputMismatchException err) {
                            err.getMessage();
                        }
                        service.addBook(magazine);
                    }
                } catch (ValidationException err) {
                    System.out.println(err.getMessage());
                }
            }
            if (opt.equals("2")) {
                System.out.println("1.Find by id");
                System.out.println("2.FInd by Name");
                var opt1 = scanner.next();
                scanner.nextLine();
                while (!opt1.matches("[1-2]")) {
                    System.out.println("Invalid input! [1-2]");
                    System.out.println("1.Find by id");
                    System.out.println("2.FInd by Name");
                }
                try {
                    if (opt1.equals("1")) {
                        System.out.println("Input id: ");
                        var id = scanner.nextLine();
                        scanner.nextLine();
                        try {
                            System.out.println(service.searchBookById(id));
                        }
                        catch (EmptyListException err){
                            System.err.println(err.getMessage());
                        }
                    } else {
                        var title = scanner.nextLine();
                        scanner.nextLine();
                        System.out.println(service.searchBookByTitle(title));
                    }
                } catch (EmptyListException err) {
                    System.err.println(err.getMessage());
                }
            }
            if (opt.equals("3")) {
                try {
                    System.out.println(service.deleteBook().getMessage());
                } catch (EmptyListException err) {
                    System.err.println(err.getMessage());
                }
            }
            if (opt.equals("4")) {
                try {
                    service.getAllBook().forEach(book -> System.out.println(book.toString()));
                } catch (EmptyListException err) {
                    System.err.println(err.getMessage());
                }
            }
            if (opt.equals("5")) {
                System.out.println("Thanks for using our app");
                condition = false;
            }
        }
    }

}