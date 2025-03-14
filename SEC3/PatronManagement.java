import java.util.ArrayList;
import java.util.Scanner;

public class PatronManagement {
    private ArrayList<User> patrons = new ArrayList<>();

    public void registerPatron(User user) {
        patrons.add(user);
        System.out.println("Patron registered successfully!");
    }

    public void viewPatrons() {
        System.out.println("List of Patrons:");
        for (User user : patrons) {
            System.out.println("Name: " + user.getNombre() +
                               ", ID: " + user.getId() +
                               ", Email: " + user.getCorreo() +
                               ", Phone: " + user.getTelefono() +
                               ", Borrowed Books: " + user.getBorrowerList());
                
        }
    }

    public User findPatronById(int id) {
        for (User user : patrons) {
            if (user.getId() == id) {
                return user;
            }
            else {
                System.out.println("Patron not found.");
            }
        }
    }

    public void editPatronByID(int id) {
        for (User user : patrons) {
            if (user.getId() == id) {
                System.out.println("Please enter the new name: ");
                Scanner obj1 = new Scanner(System.in);
                user.setNombre(obj1.nextLine());
                System.out.println("Please enter the new email: ");
                user.setCorreo(obj1.nextLine());
                System.out.println("Please enter the new phone number: ");
                user.setTelefono(obj1.nextInt());
            }
        }
    }

}
