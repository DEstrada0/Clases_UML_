import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManagment bookManagment = new BookManagment();
        PatronManagement patronManagement = new PatronManagement();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Register Patron");
            System.out.println("5. View Patrons");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Search Books");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    Book book = new Book(title, author, isbn, quantity);
                    bookManagment.addBook(book);
                    System.out.println("Book added!");
                    break;

                case 2:
                    System.out.print("Enter Title to remove: ");
                    String removeTitle = scanner.nextLine();
                    bookManagment.removeBook(removeTitle);
                    System.out.println("Book removed (if existed).");
                    break;

                case 3:
                    bookManagment.displayBooks();
                    break;

                case 4:
                    System.out.print("Enter Patron Name: ");
                    String patronName = scanner.nextLine();
                    System.out.print("Enter Patron ID: ");
                    int patronId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Patron Email: ");
                    String patronEmail = scanner.nextLine();
                    System.out.print("Enter Patron Phone: ");
                    int patronPhone = scanner.nextInt();
                    scanner.nextLine();

                    User newUser = new User(patronName, patronId, patronEmail, patronPhone);
                    patronManagement.registerPatron(newUser);
                    break;

                case 5:
                    patronManagement.viewPatrons();
                    break;

                case 6:
                    System.out.print("Enter Patron ID: ");
                    int borrowId = scanner.nextInt();
                    scanner.nextLine();

                    User borrower = patronManagement.findPatronById(borrowId);
                    if (borrower == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.print("Enter Book Title to Borrow: ");
                    String borrowTitle = scanner.nextLine();

                    Book borrowBook = null;
                    for (Book b : bookManagment.inventory) {
                        if (b.getTitle().equalsIgnoreCase(borrowTitle)) {
                            borrowBook = b;
                            break;
                        }
                    }

                    if (borrowBook != null && borrowBook.getQuantityAvailable() > 0) {
                        bookManagment.borrowingbook(borrowBook, borrower.getNombre(), borrowTitle, borrower);
                        System.out.println("Book borrowed!");
                    } else {
                        System.out.println("Book not available.");
                    }
                    break;

                case 7:
                    System.out.print("Enter Patron ID: ");
                    int returnId = scanner.nextInt();
                    scanner.nextLine();

                    User returner = patronManagement.findPatronById(returnId);
                    if (returner == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.print("Enter Book Title to Return: ");
                    String returnTitle = scanner.nextLine();

                    Book returnBook = null;
                    for (Book b : bookManagment.inventory) {
                        if (b.getTitle().equalsIgnoreCase(returnTitle)) {
                            returnBook = b;
                            break;
                        }
                    }

                    if (returnBook != null) {
                        bookManagment.returnBook(returnBook, returner.getNombre(), returnTitle, returner);
                        System.out.println("Book returned!");
                    } else {
                        System.out.println("Book not found in library.");
                    }
                    break;

                case 8:
                    System.out.print("Enter search keyword (title, author, ISBN): ");
                    String keyword = scanner.nextLine();
                    bookManagment.searchBooks(keyword);
                    break;

                case 9:
                    System.out.println("Exiting Library Management System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
