import java.util.ArrayList;

// package Inventory.Model;

public class User{

    private String nombre;
    private int Id;  
    private String correo;
    private int telefono;  
    private ArrayList<String> borrowerList = new ArrayList<String>();

    public User(String nombre, int Id, String correo, int telefono) {  
        this.nombre = nombre;  
        this.Id = Id;  
        this.correo = correo;  
        this.telefono = telefono; 

    }

    
    //setters
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setId(int Id){
        this.Id = Id;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setTelefono(int telefono){
        this.telefono = telefono;
    }

    public void addBorrower(String borrowed){
        this.borrowerList.add(borrowed);
    }

    public void removeBorrower(String borrowed){
        this.borrowerList.remove(borrowed);
    }

    //getters
    public String getNombre(){
        return nombre;
    }

    public int getId(){
        return Id;
    }

    public String getCorreo(){
        return correo;
    }

    public int getTelefono(){
        return  telefono;
    }

    public ArrayList<String> getBorrowerList(){
        return this.borrowerList;
    }
}


// public static void main(String[] args) { 