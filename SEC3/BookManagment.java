// package Inventory.Model;
import java.util.ArrayList;
import java.util.List;

public class BookManagment{
    ArrayList<Book> inventory = new ArrayList<Book>();

    public void addBook(Book book){
        inventory.add(book);
    }

    public void removeBook(String tittle){
        
        for (int i = 0; i< inventory.size();i++){
            if(inventory.get(i).getTitle().equals(tittle)){
                inventory.remove(i);
            }
        }
        
        
    }

    public void borrowingbook(Book book, String borrower, String tittle, User user){
        for (int i = 0; i< inventory.size();i++){
            if(inventory.get(i).getTitle().equals(tittle)){
                if(book.getQuantityAvailable() > 0){
                    book.setQuantityAvailable(book.getQuantityAvailable()-1);
                    book.addBorrower(borrower);
                    user.addBorrower(tittle);
                }
            }
        }
    }




    public void returnBook(Book book, String borrower, String tittle, User user){
        
        for (int i = 0; i< inventory.size();i++){
            if(inventory.get(i).getTitle().equals(tittle)){
                if(book.getBorrowerList().contains(borrower)){ 
                book.setQuantityAvailable(book.getQuantityAvailable()+1);
                book.removeBorrower(borrower);
                user.removeBorrower(tittle);
                }
            }
        }
    }

    public void displayBooks() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getTitle());
            System.out.println();
            System.out.println("Name book: " + inventory.get(i).getAuthor() + "\n" + "ISBN: " + inventory.get(i).getISBN() + "\n" + "Quantity: " + inventory.get(i).getQuantityAvailable() + "\n");
        }
    }

    public void searchBooks(String keyword) {
        System.out.println("Search results for: " + keyword);
        for (Book book : inventory) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getISBN().contains(keyword)) {
                System.out.println("Title: " + book.getTitle() +
                                   ", Author: " + book.getAuthor() +
                                   ", ISBN: " + book.getISBN() +
                                   ", Quantity: " + book.getQuantityAvailable());
            }
        }
    }
    

}

