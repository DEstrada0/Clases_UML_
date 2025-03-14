import java.util.ArrayList;

// package Inventory.Model;

public class Book{

    private String title;
    private String author;  
    private String ISBN;  
    private int quantityAvailable;
    private ArrayList<String> borrowerList = new ArrayList<String>();

    public Book(String title, String author, String ISBN, int quantityAvailable) {  
        this.title = title;  
        this.author = author;  
        this.ISBN = ISBN;  
        this.quantityAvailable = quantityAvailable;  

    }

    
    public ArrayList<String> getBorrowerList(){
        return this.borrowerList;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }   

    public void setISBN(String ISBN){
        this.ISBN= ISBN;
    }


    public String getTitle() {  
        return title;  
    }

    public String getAuthor() {  
        return author;  
    }

    public int getQuantityAvailable() {  
        return quantityAvailable;  
    }

    public String getISBN() {  
        return ISBN;  
    }

    public void setQuantityAvailable(int quantityAvailable) {  
        this.quantityAvailable = quantityAvailable;  
    }

    public void addBorrower(String borrower){
        this.borrowerList.add(borrower);
    } 

    public void removeBorrower(String borrower){
        this.borrowerList.remove(borrower);
    } 

}

