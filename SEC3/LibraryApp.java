import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManagment bookManagment = new BookManagment();
        PatronManagement patronManagement = new PatronManagement();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Edit Book"); //This one is new
            System.out.println("3. Remove Book");
            System.out.println("4. Display Books");
            System.out.println("5. Register Patron");
            System.out.println("6. View Patrons");
            System.out.println("7. Edit Patron"); //This one is new
            System.out.println("8. Search Patron"); //This one is new
            System.out.println("9. Borrow Book");
            System.out.println("10. Return Book");
            System.out.println("11. Search Books");
            System.out.println("12. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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


                case 2: //new for edit
                    System.out.print("Enter search keyword (title, author, ISBN): ");
                    String keyword = scanner.nextLine();
                    bookManagment.editBook(keyword);
                    break;
                

                    
                case 3:
                    System.out.print("Enter Title to remove: ");
                    String removeTitle = scanner.nextLine();
                    bookManagment.removeBook(removeTitle);
                    System.out.println("Book removed (if existed).");
                    break;

                case 4:
                    bookManagment.displayBooks();
                    break;

                case 5:
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

                case 6:
                    patronManagement.viewPatrons();
                    break;

                case 7: //new
                    System.out.print("Enter Patron ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    patronManagement.editPatronByID(editId);
                    break;

                case 8: //new
                    System.out.print("Enter Patron ID to find: ");
                    int findID = scanner.nextInt();
                    scanner.nextLine();
                    patronManagement.findPatronById(findID);
                    break;
                
                case 9:
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

                case 10:
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

                case 11:
                    System.out.print("Enter search keyword (title, author, ISBN): ");
                    String answer1 = scanner.nextLine();
                    bookManagment.searchBooks(answer1);
                    break;

                case 12:
                    System.out.println("Exiting Library Management System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
